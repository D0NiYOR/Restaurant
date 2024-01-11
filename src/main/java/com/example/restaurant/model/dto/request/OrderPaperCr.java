package com.example.restaurant.model.dto.request;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderPaperCr {
    private List<OrderCr> orders;
    private UUID stolId;

}
