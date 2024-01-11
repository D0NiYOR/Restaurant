package com.example.restaurant.servie;

import com.example.restaurant.model.FoodEntity;
import com.example.restaurant.model.dto.request.FoodCr;
import com.example.restaurant.model.dto.request.FoodUpdate;
import com.example.restaurant.model.dto.response.FoodResponse;
import com.example.restaurant.model.enums.OrderStatus;
import com.example.restaurant.model.exceptions.DataNotFoundException;
import com.example.restaurant.model.exceptions.DuplicateValueException;
import com.example.restaurant.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import org.modelmapper.TypeToken;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;
    private final ModelMapper modelMapper;

    public FoodResponse createFood(FoodCr foodCr){
        FoodEntity foodEntity = modelMapper.map(foodCr, FoodEntity.class);
        List<FoodEntity> foods = foodRepository.findByName(foodCr.getName());
        for (FoodEntity entity : foods) {
            if(!Objects.equals(null,entity) &&
                    Objects.equals(entity.getName(),foodEntity.getName())
                    ){
                throw new DuplicateValueException("Food already exist by these values!");
            }
        }

        return modelMapper.map(foodRepository.save(foodEntity), FoodResponse.class);
    }

    public void deleteFood(UUID foodId) {
        foodRepository.findById(foodId)
                .orElseThrow(() -> new DataNotFoundException("Food not found with ID: " + foodId));
        foodRepository.deleteById(foodId);
    }
    public FoodResponse updateById(UUID foodId, FoodUpdate update) {
        FoodEntity food = foodRepository
                .findById(foodId)
                .orElseThrow( () -> new DataNotFoundException("food not found"));

         food.setName(update.getName());
         food.setPrice(update.getPrice());
        foodRepository.save(food);
        return new FoodResponse(update.getName(),update.getPrice(),foodId);
    }

    @Override
    public List<FoodResponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return modelMapper.map(foodRepository.findAll(pageable).getContent(),
                new TypeToken<List<FoodResponse>>() {}.getType());
    }

}
