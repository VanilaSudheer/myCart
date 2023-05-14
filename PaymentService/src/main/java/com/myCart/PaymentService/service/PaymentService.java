package com.myCart.PaymentService.service;

import com.myCart.PaymentService.model.PaymentRequest;

public interface PaymentService {
    long doPayment(PaymentRequest paymentRequest);
}
