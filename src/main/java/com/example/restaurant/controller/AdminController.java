package com.example.restaurant.controller;

import com.example.restaurant.model.dto.request.FoodCr;
import com.example.restaurant.model.dto.request.FoodUpdate;
import com.example.restaurant.model.dto.request.StolCr;
import com.example.restaurant.model.dto.request.StolUpdate;
import com.example.restaurant.model.dto.response.FoodResponse;
import com.example.restaurant.model.dto.response.StolResponse;
import com.example.restaurant.servie.FoodService;
import com.example.restaurant.servie.StolService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/admins")
public class AdminController {

    private final FoodService foodService;
    private final StolService stolService;


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create-food")
    public ResponseEntity<FoodResponse> createFood(@RequestBody @Valid FoodCr foodCr) {
        return ResponseEntity.ok(foodService.createFood(foodCr));
    }

    @PreAuthorize("hasRole('ADMIN') ")
    @PutMapping("/update-food")
    public ResponseEntity<FoodResponse> update(
            @RequestParam UUID foodId,
            @RequestBody FoodUpdate update) {
        return ResponseEntity.status(200).body(foodService.updateById(foodId, update));
    }

    @PreAuthorize(" hasRole('ADMIN')")
    @DeleteMapping("/delete-food/{foodId}")
    public ResponseEntity<String> deleteFood(@PathVariable UUID foodId) {
        foodService.deleteFood(foodId);
        return new ResponseEntity<>("Food deleted successfully", HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/get-all-food")
    public List<FoodResponse> getAllFood(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return foodService.getAll(page, size);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create-stol")
    public ResponseEntity<StolResponse> createStol(@RequestBody @Valid StolCr stolCr) {
        return ResponseEntity.ok(stolService.createStol(stolCr));
    }
    @PreAuthorize("hasRole('ADMIN') ")
    @PutMapping("/update-stol")
    public ResponseEntity<StolResponse> update(
            @RequestParam UUID stolId,
            @RequestBody StolUpdate update) {
        return ResponseEntity.status(200).body(stolService.updateById(stolId, update));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/get-all-stol")
    public List<StolResponse> getAllStol(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return stolService.getAll(page, size);
    }
    @PreAuthorize(" hasRole('ADMIN')")
    @DeleteMapping("/delete-stol/{stolId}")
    public ResponseEntity<String> deleteStol(@PathVariable UUID stolId) {
        stolService.deleteStol(stolId);
        return new ResponseEntity<>("Stol deleted successfully", HttpStatus.OK);
    }




}
