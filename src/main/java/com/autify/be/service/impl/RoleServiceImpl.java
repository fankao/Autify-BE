package com.autify.be.service.impl;

import com.autify.be.entity.Role;
import com.autify.be.exceptions.ApplicationInternalError;
import com.autify.be.exceptions.BadRequestException;
import com.autify.be.exceptions.NotFoundException;
import com.autify.be.repo.RoleRepository;
import com.autify.be.service.RoleService;
import com.autify.be.model.RoleDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public RoleDTO create(RoleDTO body) {
        if (roleRepository.existsByName(body.getName())) {
            throw new BadRequestException("Role with name " + body.getName() + " is existing");
        }
        try {
            Role role = new Role(body.getName());
            roleRepository.save(role);
            return body;
        } catch (Exception e) {
            log.info("create() >> {}", e.getMessage());
            throw new ApplicationInternalError(e.getMessage());
        }
    }

    @Override
    public RoleDTO update(RoleDTO body) {
        Role existedRole = roleRepository.findById(body.getId())
                .orElseThrow(() -> new NotFoundException("Role not found"));
        try {
            existedRole.setName(body.getName());
            roleRepository.save(existedRole);
            return body;
        } catch (Exception e) {
            log.info("update() >> {}", e.getMessage());
            throw new ApplicationInternalError(e.getMessage());
        }
    }

    @Override
    public void deleteById(Long roleId) {
        if (!roleRepository.existsById(roleId)) {
            throw new NotFoundException("Role with id " + roleId + " not found");
        }
        try {
           roleRepository.deleteById(roleId);
        } catch (Exception e) {
            log.info("delete() >> {}", e.getMessage());
            throw new ApplicationInternalError(e.getMessage());
        }
    }

    @Override
    public RoleDTO getRole(Long roleId) {
        Role existedRole = roleRepository.findById(roleId)
                .orElseThrow(() -> new NotFoundException("Role not found"));
        return new RoleDTO().name(existedRole.getName());
    }
}
