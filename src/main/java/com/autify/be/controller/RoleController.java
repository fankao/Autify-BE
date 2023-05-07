package com.autify.be.controller;

import com.autify.be.api.RoleApi;
import com.autify.be.service.RoleService;
import com.autify.be.model.RoleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
@RequiredArgsConstructor
public class RoleController implements RoleApi {
    private final RoleService roleService;

    @Override
    public ResponseEntity<RoleDTO> createRole(@Valid @RequestBody RoleDTO body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(roleService.create(body));
    }

    @Override
    public ResponseEntity<RoleDTO> updateRole(@Valid @RequestBody RoleDTO body) {
        return ResponseEntity.ok(roleService.update(body));
    }

    @Override
    public ResponseEntity<Void> deleteRole(Long roleId) {
        roleService.deleteById(roleId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<RoleDTO> getRole(Long roleId) {
        return ResponseEntity.ok(roleService.getRole(roleId));
    }

    @Override
    public ResponseEntity<RoleDTO> getOwnedPermissions(Long roleId) {
        return RoleApi.super.getOwnedPermissions(roleId);
    }

    @Override
    public ResponseEntity<RoleDTO> assignPermission(Long roleId, Long permissionId) {
        return RoleApi.super.assignPermission(roleId, permissionId);
    }

    @Override
    public ResponseEntity<RoleDTO> removeAssignedPermission(Long roleId, Long permissionId) {
        return RoleApi.super.removeAssignedPermission(roleId, permissionId);
    }
}
