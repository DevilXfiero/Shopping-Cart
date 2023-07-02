package com.project.ShoppingCart.service;

import com.project.ShoppingCart.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> fetchProductList();

    public Product addProduct(Product product);

    public void deleteProductById(Long productId);

    public Product getProductById(Long productID);
}
