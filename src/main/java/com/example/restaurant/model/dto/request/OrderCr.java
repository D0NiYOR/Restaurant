package com.example.restaurant.model.dto.request;

import com.example.restaurant.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderCr {
    private UUID foodId;
    private Integer count;
    private OrderStatus status;
}
