package com.autify.be.controller;

import com.autify.be.api.SessionApi;
import com.autify.be.model.LoginRequestDTO;
import com.autify.be.model.SessionDTO;
import com.autify.be.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SessionController implements SessionApi {
    private final SessionService sessionService;

    @Override
    public ResponseEntity<SessionDTO> trackingLogin(@RequestBody LoginRequestDTO requestBody,@RequestHeader String clientIp) {
        return ResponseEntity.ok(sessionService.trackUserLogin(requestBody,clientIp));
    }
}
