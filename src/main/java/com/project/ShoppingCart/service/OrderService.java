package com.project.ShoppingCart.service;

import com.project.ShoppingCart.entity.Orders;

import java.util.List;

public interface OrderService {
    public List<Orders> fetchOrderList();
}
