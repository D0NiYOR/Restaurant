package com.example.restaurant.repository;

import com.example.restaurant.model.OrderPaperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface OrderPaperRepository extends JpaRepository<OrderPaperEntity, UUID> {

}
