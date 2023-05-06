package com.autify.be.api.repo;

import com.autify.be.api.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {
    boolean existsByName(String name);
}
