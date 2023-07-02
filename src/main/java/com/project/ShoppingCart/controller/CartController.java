package com.project.ShoppingCart.controller;

import com.project.ShoppingCart.entity.Cart;
import com.project.ShoppingCart.entity.Orders;
import com.project.ShoppingCart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    @Autowired
    public CartService cartService;

    @PostMapping("/customer/{customer_id}/cart/add_to_cart/{product_id}")
    public Cart addItemtoCart(@PathVariable("customer_id") Long customerId,@PathVariable("product_id") Long productId)
    {
        return cartService.addItemtoCart(customerId,productId);

    }

    @GetMapping("/{cart_id}/cart")
    public Cart viewCart(@PathVariable("cart_id") Long cartId)
    {
        return cartService.viewCart(cartId);
    }



    @DeleteMapping("/cart/{cart_id}/remove/{product_id}")
    public Cart removeFromCart(@PathVariable("cart_id") Long cartId,@PathVariable("product_id") Long productId)
    {
        return cartService.removeFromCart(cartId,productId);
    }

    @DeleteMapping("/cart/{cart_id}")
    public String removeCart(@PathVariable("cart_id") Long cartId)

    {
         cartService.removeCart(cartId);
         return "Cart removed successfully";

    }
    @DeleteMapping("/remove_all")
    public String removeAllCart() {
      cartService.removeAllCart();
      return "deleted successfully";
    }


}

