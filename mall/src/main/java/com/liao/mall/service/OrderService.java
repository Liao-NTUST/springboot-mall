package com.liao.mall.service;

import com.liao.mall.dto.CreateOrderRequest;
import com.liao.mall.dto.OrderQueryParams;
import com.liao.mall.model.Order;
import jakarta.validation.Valid;

import java.util.List;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);
}
