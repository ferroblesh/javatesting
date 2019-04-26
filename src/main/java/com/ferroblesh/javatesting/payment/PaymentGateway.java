package com.ferroblesh.javatesting.payment;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);
}
