package com.project.ShoppingCart.service;

import com.project.ShoppingCart.entity.Cart;
import com.project.ShoppingCart.entity.Customer;
import com.project.ShoppingCart.entity.Orders;
import com.project.ShoppingCart.error.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {
    public Customer addCustomer(Customer customer);

    public List<Customer> fetchCustomerList();

    public Cart viewCartById(Long customerId);

    public Customer viewCustomerById(Long customerId) throws CustomerNotFoundException;

    public Orders placeOrder(Long customerId);
}
