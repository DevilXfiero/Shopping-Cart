package com.project.ShoppingCart.controller;


import com.project.ShoppingCart.entity.Product;
import com.project.ShoppingCart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    public ProductService productService;

    @GetMapping("/products")
    public List<Product> fetchProductList() {
     return productService.fetchProductList();
    }


    @PostMapping("/add_product")
    public  Product addProduct(@RequestBody Product product)
    {
        return productService.addProduct(product);
    }

    @DeleteMapping("/delete_product/{id}")
    public String deleteProductById(@PathVariable("id") Long productId)
    {
        productService.deleteProductById(productId);
        return "Product deleted successfully!";
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable("id") Long productID)
    {
       return productService.getProductById(productID);
    }


}
