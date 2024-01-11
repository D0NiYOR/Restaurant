package com.example.restaurant.controller;

import com.example.restaurant.model.dto.request.OrderCr;

import com.example.restaurant.model.dto.request.OrderPaperCr;
import com.example.restaurant.model.dto.response.CheckResponse;
import com.example.restaurant.model.dto.response.OrderPaperResponse;
import com.example.restaurant.servie.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/waiters")
public class WaiterController {
    private final OrderService orderService;


    @PreAuthorize(" hasRole('WAITER') ")
    @PostMapping("/create-order")
    public OrderPaperResponse createOrder(OrderPaperCr paper){
        return orderService.createOrder(paper);
    }
    @PreAuthorize(" hasRole('WAITER') ")
    @PostMapping("/finish-order")
    public CheckResponse finishOrder(UUID orderPaperId){
        return orderService.finishOrder(orderPaperId);
    }



}
