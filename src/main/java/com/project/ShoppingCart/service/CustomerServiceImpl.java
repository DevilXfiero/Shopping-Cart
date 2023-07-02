package com.project.ShoppingCart.service;

import com.project.ShoppingCart.entity.Cart;
import com.project.ShoppingCart.entity.Customer;
import com.project.ShoppingCart.entity.Orders;
import com.project.ShoppingCart.entity.Product;
import com.project.ShoppingCart.repository.CartRepository;
import com.project.ShoppingCart.repository.CustomerRepository;
import com.project.ShoppingCart.repository.OrderRepository;
import com.project.ShoppingCart.error.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    public CustomerRepository customerRepository;
    @Autowired
    public CartRepository cartRepository;

    @Autowired
    public OrderRepository orderRepository;
    @Override
    public Customer addCustomer(Customer customer) {
        Cart cart = new Cart(customer.getCustomerId());
        customer.setCart(cart);
        cartRepository.save(cart);



        return customerRepository.save(customer);
    }



    @Override
    public List<Customer> fetchCustomerList() {
        return customerRepository.findAll();
    }

    @Override
    public Cart viewCartById(Long customerId) {

        return cartRepository.findById(customerId).get();
    }



    @Override
    public Customer viewCustomerById(Long customerId) throws CustomerNotFoundException {


        Optional<Customer> customerOptional= customerRepository.findById(customerId);
        if(!customerOptional.isPresent())
        {
            throw new CustomerNotFoundException("Customer not available");
        }
        else
        {
            return customerOptional.get();
        }
    }

    @Override
    public Orders placeOrder(Long customerId) {
        Orders orders = new Orders();
        Customer customer= customerRepository.findById(customerId).get();
        Cart cart= cartRepository.findById(customerId).get();
        orders.setStatus("ordered");
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();

        orders.setDateCreated(currentDate);
        orders.setLastModifiedDate(currentDate);

        for(Product product: cart.getProductList())
        {
            orders.getProductList().add(product);

        }
        cart.getProductList().clear();

        customer.getOrderList().add(orders);
        orders.setCustomer(customer);

        return orderRepository.save(orders);
    }

}
