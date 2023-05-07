package com.autify.be.entity;

import lombok.*;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseEntity{
    private String name;

    @ManyToMany
    @JoinTable(
            name = "role_permission",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<Permission> permissions = new HashSet<>();

    public Role(String name) {
        this.name = name;
    }

    public void addPermission(Permission permission){
        this.permissions.add(permission);
        permission.getRoles().add(this);
    }

    public void removePermission(Permission permission){
        if(CollectionUtils.isEmpty(permissions)){
            return;
        }
        this.permissions.remove(permission);
        permission.getRoles().remove(this);
    }


}
