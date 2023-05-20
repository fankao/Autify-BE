package com.autify.be.service;

import com.autify.be.model.LoginRequestDTO;
import com.autify.be.model.SessionDTO;

public interface SessionService {
    SessionDTO trackUserLogin(LoginRequestDTO loginRequest, String clientIp);
}
