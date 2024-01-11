package com.example.restaurant.servie;

import com.example.restaurant.model.FoodEntity;
import com.example.restaurant.model.dto.request.FoodCr;
import com.example.restaurant.model.dto.request.FoodUpdate;
import com.example.restaurant.model.dto.response.FoodResponse;

import java.util.List;
import java.util.UUID;

public interface FoodService {
     FoodResponse createFood(FoodCr newFood);

     void deleteFood(UUID foodId);
      FoodResponse updateById(UUID studentId, FoodUpdate update);

    List<FoodResponse> getAll(int page, int size);

}
