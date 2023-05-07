package com.autify.be.service;

import com.autify.be.model.UserDTO;

public interface UserService {
    UserDTO create(UserDTO body);

    UserDTO update(UserDTO body);

    void deleteById(Long userId);

    UserDTO getUserById(Long userId);
}
