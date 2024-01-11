package com.example.restaurant.servie;

import com.example.restaurant.model.dto.request.OrderCr;
import com.example.restaurant.model.dto.request.OrderPaperCr;
import com.example.restaurant.model.dto.response.CheckResponse;
import com.example.restaurant.model.dto.response.OrderPaperResponse;

import java.util.List;
import java.util.UUID;

public interface OrderService {
     OrderPaperResponse createOrder(OrderPaperCr orderPaper);

     CheckResponse finishOrder(UUID orderPaperId);
//    CheckListResponse order(List<OrderCr> orders);
}
