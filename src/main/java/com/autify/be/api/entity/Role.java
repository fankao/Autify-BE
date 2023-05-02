package com.autify.be.api.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "role")
@Data
public class Role extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private ERole name;
}
