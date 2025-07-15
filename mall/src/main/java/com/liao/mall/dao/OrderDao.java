package com.liao.mall.dao;

import com.liao.mall.dto.CreateOrderRequest;
import com.liao.mall.model.Order;
import com.liao.mall.model.Orderitem;

import java.util.List;

public interface OrderDao {

    Integer createOrder(Integer userId,Integer totalAmount);

    void createOrderItem(Integer orderId, List<Orderitem> orderitemList);

    Order getOrderById(Integer orderId);

    List<Orderitem> getOrderItemsByOrderId(Integer orderId);
}
