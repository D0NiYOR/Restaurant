package com.example.restaurant.repository;

import com.example.restaurant.model.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, UUID> {
    List<FoodEntity> findByName(String name);
}
