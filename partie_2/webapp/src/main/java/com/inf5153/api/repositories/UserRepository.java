package com.inf5153.api.repositories;

import java.util.Optional;
import com.inf5153.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String userName);
}