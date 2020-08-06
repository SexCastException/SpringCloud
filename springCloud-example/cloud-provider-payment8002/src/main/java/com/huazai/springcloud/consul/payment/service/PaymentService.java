package com.huazai.springcloud.consul.payment.service;


import com.huazai.springcloud.commons.entities.Payment;

/**
 * @author pyh
 * @date 2020/7/15 21:26
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
