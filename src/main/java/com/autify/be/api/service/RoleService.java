package com.autify.be.api.service;

import com.autify.be.model.RoleDTO;

public interface RoleService {

    RoleDTO create(RoleDTO body);

    RoleDTO update(RoleDTO body);
}
