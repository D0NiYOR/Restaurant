package com.example.restaurant.repository;

import com.example.restaurant.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    boolean existsByPhoneNumber(String phoneNumber);
    Optional<UserEntity> findByPhoneNumber(String phoneNumber);
}
