package com.autify.be.api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "role")
@Data
@NoArgsConstructor
public class Role extends BaseEntity{
    private String name;

    public Role(String name) {
        this.name = name;
    }
}
