package com.autify.be.repo;

import com.autify.be.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {
    boolean existsByName(String name);
}
