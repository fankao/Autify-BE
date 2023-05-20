package com.autify.be.service.impl;

import com.autify.be.entity.Session;
import com.autify.be.entity.User;
import com.autify.be.exceptions.ApplicationInternalError;
import com.autify.be.exceptions.NotFoundException;
import com.autify.be.model.LoginRequestDTO;
import com.autify.be.model.SessionDTO;
import com.autify.be.repo.SessionRepository;
import com.autify.be.repo.UserRepository;
import com.autify.be.service.SessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepo;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public SessionDTO trackUserLogin(LoginRequestDTO loginRequest, String clientIp) {
        User existingUser = userRepository.findByUsernameOrEmail(loginRequest.getUsername())
                .orElseThrow(() -> new NotFoundException("User with username or email: " + loginRequest.getUsername() + " is not existing"));
        try {
            Session session = new Session(UUID.randomUUID().toString(), Timestamp.valueOf(LocalDateTime.now()), clientIp);
            session.addSession(existingUser);
            sessionRepo.save(session);
            return new SessionDTO()
                    .sessionId(session.getSessionId())
                    .loginTime(DateTimeFormatter.ISO_INSTANT.format(session.getLoginTime().toInstant()))
                    .ipAddress(session.getIpAddress());
        } catch (Exception e) {
            log.info("trackUserLogin >> error: {}", e.getMessage());
            throw new ApplicationInternalError(e.getMessage());
        }
    }
}
