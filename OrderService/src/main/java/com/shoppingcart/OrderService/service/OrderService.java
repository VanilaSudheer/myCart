package com.shoppingcart.OrderService.service;

import com.shoppingcart.OrderService.entity.Order;
import com.shoppingcart.OrderService.model.OrderRequest;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    Long placeOrder(OrderRequest orderRequest);
}

