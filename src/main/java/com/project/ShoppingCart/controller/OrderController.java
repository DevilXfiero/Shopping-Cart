package com.project.ShoppingCart.controller;

import com.project.ShoppingCart.entity.Orders;
import com.project.ShoppingCart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    public OrderService orderService;

    @GetMapping("/orders")
    public List<Orders> fetchOrderList()
    {
        return orderService.fetchOrderList();
    }


}
