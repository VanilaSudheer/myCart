package com.shoppingcart.OrderService.service;

import com.shoppingcart.OrderService.entity.Order;
import com.shoppingcart.OrderService.external.client.ProductService;
import com.shoppingcart.OrderService.model.OrderRequest;
import com.shoppingcart.OrderService.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    private ProductService productService;
    @Override
    public Long placeOrder(OrderRequest orderRequest) {
        log.info("placing the order: {}",orderRequest);
        productService.reduceQuantity(orderRequest.getProductId(),orderRequest.getQuantity());
        log.info("creating order with status CREATED");

        Order order= Order.builder()
                .productId(orderRequest.getProductId())
                .amount(orderRequest.getTotalAmount())
                .quantity(orderRequest.getQuantity())
                .orderStatus("CREATED")
                .orderDate(Instant.now())
                .build();
        order = orderRepository.save(order);
        log.info("Order placed with orderId:{}",order.getId());
        return order.getId();
    }
}
