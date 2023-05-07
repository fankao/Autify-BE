package com.autify.be.service.impl;

import com.autify.be.entity.Permission;
import com.autify.be.entity.Role;
import com.autify.be.exceptions.ApplicationInternalError;
import com.autify.be.exceptions.BadRequestException;
import com.autify.be.exceptions.NotFoundException;
import com.autify.be.repo.PermissionRepository;
import com.autify.be.repo.RoleRepository;
import com.autify.be.service.RoleService;
import com.autify.be.model.RoleDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    private final PermissionRepository permissionRepository;
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

    @Transactional
    @Override
    public RoleDTO assignPermission(Long roleId, Long permissionId) {
        Role existedRole = roleRepository.findById(roleId)
                .orElseThrow(() -> new NotFoundException("Role not found"));
        Permission permission = permissionRepository.findById(permissionId)
                .orElseThrow(() -> new NotFoundException("Permission not found"));
        try {
            existedRole.addPermission(permission);
            roleRepository.save(existedRole);
            return new RoleDTO()
                    .name(existedRole.getName())
                    .permissions(existedRole.getPermissions().stream()
                            .map(Permission::getName).toList());
        } catch (Exception e) {
            log.info("assignPermission() >> {}", e.getMessage());
            throw new ApplicationInternalError(e.getMessage());
        }
    }

    @Transactional
    @Override
    public RoleDTO removeAssignedPermission(Long roleId, Long permissionId) {
        Role existedRole = roleRepository.findById(roleId)
                .orElseThrow(() -> new NotFoundException("Role not found"));
        Permission permission = permissionRepository.findById(permissionId)
                .orElseThrow(() -> new NotFoundException("Permission not found"));
        try {
            existedRole.removePermission(permission);
            roleRepository.save(existedRole);
            return new RoleDTO()
                    .name(existedRole.getName())
                    .permissions(existedRole.getPermissions().stream()
                            .map(Permission::getName).toList());
        } catch (Exception e) {
            log.info("removeAssignedPermission() >> {}", e.getMessage());
            throw new ApplicationInternalError(e.getMessage());
        }
    }

    @Transactional
    @Override
    public RoleDTO getPermissions(Long roleId) {
        Role existedRole = roleRepository.findById(roleId)
                .orElseThrow(() -> new NotFoundException("Role not found"));
        return new RoleDTO()
                .name(existedRole.getName())
                .permissions(existedRole.getPermissions().stream()
                        .map(Permission::getName).toList());
    }
}
