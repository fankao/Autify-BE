package com.autify.be.controller;

import com.autify.be.api.UserApi;
import com.autify.be.model.UserDTO;
import com.autify.be.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Log
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO body){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(body));
    }

    @Override
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO body) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(body));
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long userId) {
        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<UserDTO> getUser(Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }
}
