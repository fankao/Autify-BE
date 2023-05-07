package com.autify.be.service;

import com.autify.be.model.RoleDTO;

public interface RoleService {

    RoleDTO create(RoleDTO body);

    RoleDTO update(RoleDTO body);

    void deleteById(Long roleId);

    RoleDTO getRole(Long roleId);
}
