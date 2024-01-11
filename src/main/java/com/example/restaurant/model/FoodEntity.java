package com.example.restaurant.model;

import com.example.restaurant.model.enums.OrderStatus;
import jakarta.persistence.Entity;
import lombok.*;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FoodEntity extends BaseEntity{
    private String name;
    private Double price;

}
