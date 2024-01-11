package com.example.restaurant.model;

import com.example.restaurant.model.enums.OrderStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class OrderEntity extends BaseEntity{
    private UUID foodId;
    private Integer count;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
