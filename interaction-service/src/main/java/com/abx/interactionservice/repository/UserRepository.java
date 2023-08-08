package com.abx.interactionservice.repository;

import com.abx.interactionservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserUuid(UUID userUuid);
    User findByToken(String token);
}
