package com.project.ShoppingCart.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.ShoppingCart.entity.Cart;
import com.project.ShoppingCart.entity.Customer;
import com.project.ShoppingCart.entity.Orders;
import com.project.ShoppingCart.service.CustomerService;
import com.project.ShoppingCart.error.CustomerNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    public CustomerService customerService;

    @PostMapping("/add_customer")
    public Customer addCustomer(@Valid @RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> fetchCustomerList() {
        return customerService.fetchCustomerList();
    }

    @PostMapping("/{customer_id}/place_order")
    public Orders placeOrder(@PathVariable("customer_id") Long customerId) {
        return customerService.placeOrder(customerId);
    }

    @GetMapping("/{customer_id}/view_cart")
    public Cart viewCartById(@PathVariable("customer_id") Long customerId) {
        return customerService.viewCartById(customerId);

    }

    @GetMapping("/customer_details/{customer_id}")
    public Customer viewCustomerById(@PathVariable("customer_id") Long customerId) throws CustomerNotFoundException {
        return customerService.viewCustomerById(customerId);
    }

    @GetMapping("/updates")
    public String getResponseApi() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("https://8332-103-75-33-66.ngrok-free.app/stocks/ALL", String.class);
        String responseBody = response.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(responseBody);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON response", e);
        }

        if (jsonNode == null || !jsonNode.isArray()) {
            throw new RuntimeException("Invalid JSON response or response is not an array");
        }

        JsonNode firstObject = jsonNode.get(0);
        if (firstObject == null) {
            throw new RuntimeException("JSON array is empty");
        }

        JsonNode branchNode = firstObject.get("branchId");
        if (branchNode == null || branchNode.isNull()) {
            throw new RuntimeException("Field 'branchId' not found in the JSON response");
        }

        String branch = branchNode.textValue();
        return branch;
    }




}
