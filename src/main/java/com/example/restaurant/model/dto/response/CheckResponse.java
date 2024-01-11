package com.example.restaurant.model.dto.response;

import com.example.restaurant.model.dto.request.OrderCr;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CheckResponse {
    private Map<OrderCr, Double> row;
    private Double overall;
}
