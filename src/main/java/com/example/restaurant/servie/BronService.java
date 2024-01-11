package com.example.restaurant.servie;

import com.example.restaurant.model.dto.response.BronResponse;
import com.example.restaurant.model.dto.response.StolResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface BronService {
    BronResponse bron(UUID userId, UUID stolId);

    ResponseEntity<List<StolResponse>> getByUserId(UUID uuid);

    void cancelBron(UUID userId, UUID bronId);
}
