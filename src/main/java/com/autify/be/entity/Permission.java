package com.autify.be.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;
@Entity
@Table(name = "permission")
@Data
@NoArgsConstructor
public class Permission extends BaseEntity{
    private String name;
    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles;
}
