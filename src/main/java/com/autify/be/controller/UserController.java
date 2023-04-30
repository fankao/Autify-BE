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
}
