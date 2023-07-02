package com.project.ShoppingCart.service;

import com.project.ShoppingCart.entity.Cart;
import com.project.ShoppingCart.entity.Orders;

public interface CartService {
    public Cart addItemtoCart(Long customerId,Long productId);


    public Cart viewCart(Long cartId);


    public Cart removeFromCart(Long cartId, Long productId);

    public void removeCart(Long cartId);

    public void removeAllCart();


}
