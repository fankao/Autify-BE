package com.autify.be.api.service;

import com.autify.be.model.UserDTO;

public interface UserService {
    UserDTO create(UserDTO body);

    UserDTO update(UserDTO body);
}