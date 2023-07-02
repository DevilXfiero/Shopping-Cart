package com.project.ShoppingCart.service;


import com.project.ShoppingCart.entity.Orders;
import com.project.ShoppingCart.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    public OrderRepository orderRepository;
    @Override
    public List<Orders> fetchOrderList() {
        return orderRepository.findAll();
    }
}
