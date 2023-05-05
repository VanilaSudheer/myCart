package com.shoppingcart.ProductService.service;

import com.shoppingcart.ProductService.model.ProductRequest;
import com.shoppingcart.ProductService.model.ProductResponse;

public interface ProductService {
    Long addProduct(ProductRequest productRequest);
    ProductResponse getProductById(Long productId);

    void reduceQuantity(long productId, long quantity);
}
