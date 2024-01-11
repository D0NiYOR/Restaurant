package com.example.restaurant.servie;

import com.example.restaurant.model.FoodEntity;
import com.example.restaurant.model.OrderEntity;
import com.example.restaurant.model.OrderPaperEntity;
import com.example.restaurant.model.dto.request.OrderCr;
import com.example.restaurant.model.dto.request.OrderPaperCr;
import com.example.restaurant.model.dto.response.CheckResponse;
import com.example.restaurant.model.dto.response.OrderPaperResponse;

import com.example.restaurant.repository.FoodRepository;
import com.example.restaurant.repository.OrderPaperRepository;
import com.example.restaurant.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderPaperRepository orderPaperRepository;
    private final ModelMapper modelMapper;
    private final FoodRepository foodRepository;

    @Override
    public OrderPaperResponse createOrder(OrderPaperCr orderPaper) {
        orderPaperRepository.save(modelMapper.map(orderPaper, OrderPaperEntity.class));
        return modelMapper.map(orderPaper, OrderPaperResponse.class);
    }
    public CheckResponse finishOrder(UUID orderPaperId){
        CheckResponse checkResponse = new CheckResponse();
        OrderPaperEntity orderPaperEntity = orderPaperRepository.findById(orderPaperId).get();
        for (OrderEntity order : orderPaperEntity.getOrders()) {
            FoodEntity foodEntity = foodRepository.findById(order.getFoodId()).get();
          checkResponse.setOverall(checkResponse.getOverall()+foodEntity.getPrice() * order.getCount());
       checkResponse.getRow().put(modelMapper.map(order,OrderCr.class),foodEntity.getPrice() * order.getCount());
        }
        return checkResponse;
    }

}
