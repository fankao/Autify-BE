package com.autify.be.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Session extends BaseEntity{
    private String sessionId;
    private Timestamp loginTime;
    private String ipAddress;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Session(String sessionId, Timestamp loginTime, String ipAddress) {
        this.sessionId = sessionId;
        this.loginTime = loginTime;
        this.ipAddress = ipAddress;
    }
    public void addSession(User user){
        this.setUser(user);
        user.getSessions().add(this);
    }
}
