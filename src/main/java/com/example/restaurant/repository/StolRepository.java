package com.example.restaurant.repository;

import com.example.restaurant.model.FoodEntity;
import com.example.restaurant.model.StolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StolRepository extends JpaRepository<StolEntity, UUID> {
    List<StolEntity> findByNumber(Integer number);
}
