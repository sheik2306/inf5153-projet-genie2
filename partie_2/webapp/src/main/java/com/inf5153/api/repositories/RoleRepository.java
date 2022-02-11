package com.inf5153.api.repositories;

import com.inf5153.api.models.Address;
import com.inf5153.api.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query("SELECT u FROM Role u WHERE u.name = ?1")
    Role findRoleByName(String name);
}
