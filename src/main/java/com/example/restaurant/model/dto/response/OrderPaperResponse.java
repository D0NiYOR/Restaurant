package com.example.restaurant.model.dto.response;

import com.example.restaurant.model.dto.request.OrderCr;
import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class OrderPaperResponse {
    private List<OrderCr> orders;
    private UUID stolId;
}
