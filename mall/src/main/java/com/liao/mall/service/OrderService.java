package com.liao.mall.service;

import com.liao.mall.dto.CreateOrderRequest;
import com.liao.mall.model.Order;
import jakarta.validation.Valid;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);
}
