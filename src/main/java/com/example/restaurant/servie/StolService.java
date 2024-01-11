package com.example.restaurant.servie;

import com.example.restaurant.model.dto.request.StolCr;
import com.example.restaurant.model.dto.request.StolUpdate;
import com.example.restaurant.model.dto.response.StolResponse;

import java.util.List;
import java.util.UUID;

public interface StolService {
    StolResponse createStol(StolCr foodCr);
    void deleteStol(UUID foodId);
    StolResponse updateById(UUID stolId, StolUpdate update);
    List<StolResponse> getAll(int page, int size);
}
