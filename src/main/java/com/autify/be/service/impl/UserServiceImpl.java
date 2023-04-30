package com.autify.be.service.impl;

import com.autify.be.api.ApiException;
import com.autify.be.api.ApiResponseMessage;
import com.autify.be.entity.User;
import com.autify.be.exceptions.ApplicationInternalError;
import com.autify.be.exceptions.BadRequestException;
import com.autify.be.model.UserDTO;
import com.autify.be.repo.UserRepository;
import com.autify.be.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
}
