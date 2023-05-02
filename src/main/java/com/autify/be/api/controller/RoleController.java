package com.autify.be.api.controller;

import com.autify.be.api.RoleApi;
import com.autify.be.api.service.RoleService;
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
}
