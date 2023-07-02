package com.project.ShoppingCart.service;

import com.project.ShoppingCart.entity.Cart;
import com.project.ShoppingCart.entity.Customer;
import com.project.ShoppingCart.entity.Orders;
import com.project.ShoppingCart.entity.Product;
import com.project.ShoppingCart.repository.CartRepository;
import com.project.ShoppingCart.repository.CustomerRepository;
import com.project.ShoppingCart.repository.OrderRepository;
import com.project.ShoppingCart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    public CartRepository cartRepository;

    @Autowired
    public ProductRepository productRepository;
    @Autowired
    public CustomerRepository customerRepository;

    @Autowired
    public OrderRepository orderRepository;
    @Override
    public Cart addItemtoCart(Long customerId,Long productId) {
        Product product = productRepository.findById(productId).get();
        Customer customer = customerRepository.findById(customerId).get();
        Cart cart=customer.getCart();


        cart.getProductList().add(product);


        return cartRepository.save(cart);

    }

    @Override
    public Cart viewCart(Long cartId) {
        return cartRepository.findById(cartId).get();
    }

    @Override
    public Cart removeFromCart(Long cartId, Long productId) {

        Cart cart= cartRepository.findById(cartId).get();
        Product toRemove=null;
        for(Product product: cart.getProductList())
        {
            if(product.getProductId()==(productId))
            {
                toRemove=product;
                break;

            }
        }
        if(toRemove!=null){
            cart.getProductList().remove(toRemove);

        }
        return cartRepository.save(cart);
    }

    @Override
    public void removeCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }

    @Override
    public void removeAllCart() {
        cartRepository.deleteAll();
    }




}
