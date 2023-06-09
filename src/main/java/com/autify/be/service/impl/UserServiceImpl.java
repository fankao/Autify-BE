package com.autify.be.service.impl;

import com.autify.be.entity.User;
import com.autify.be.exceptions.ApplicationInternalError;
import com.autify.be.exceptions.BadRequestException;
import com.autify.be.exceptions.NotFoundException;
import com.autify.be.model.UserDTO;
import com.autify.be.repo.UserRepository;
import com.autify.be.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDTO create(UserDTO body) {
        if (userRepository.existsByEmail(body.getEmail())) {
            throw new BadRequestException("User with email " + body.getEmail() + " is existing");
        }
        try {
            userRepository.save(new User(body.getName(), body.getEmail(), body.getPassword()));
            return body;
        } catch (Exception e) {
            log.error("create() --> {}", e.getMessage());
            throw new ApplicationInternalError(e.getMessage());
        }
    }

    @Override
    public UserDTO update(UserDTO body) {
        if (!userRepository.existsById(body.getId())) {
            throw new NotFoundException("User with Id " + body.getId() + " is not existing");
        }
        try {
            User user = new User(body.getName(), body.getEmail(), body.getPassword());
            user.setId(body.getId());
            userRepository.save(user);
            return body;
        } catch (Exception e) {
            log.error("update() --> {}", e.getMessage());
            throw new ApplicationInternalError(e.getMessage());
        }
    }

    @Override
    public void deleteById(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new NotFoundException("User with Id " + userId + " is not existing");
        }
        try {
            userRepository.deleteById(userId);
        } catch (Exception e) {
            log.error("deleteById() --> {}", e.getMessage());
            throw new ApplicationInternalError(e.getMessage());
        }

    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User with Id " + userId + " is not existing"));
        return new UserDTO()
                .email(user.getEmail())
                .name(user.getUserName());
    }
}
