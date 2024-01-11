package com.example.restaurant.repository;

import com.example.restaurant.model.BronEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface BronRepository extends JpaRepository<BronEntity, UUID> {
    List<BronEntity> findAllByUserId(UUID userid);
   Optional<BronEntity> findByUserIdAndStolId(UUID userId,UUID stolId);
}
