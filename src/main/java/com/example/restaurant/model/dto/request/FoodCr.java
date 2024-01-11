package com.example.restaurant.model.dto.request;

import lombok.*;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FoodCr {
    private String name;
    private BigDecimal price;


}
