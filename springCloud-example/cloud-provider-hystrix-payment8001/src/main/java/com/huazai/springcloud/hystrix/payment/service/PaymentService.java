package com.huazai.springcloud.hystrix.payment.service;

/**
 * @author pyh
 * @date 2020/7/23 22:10
 */
public interface PaymentService {
    String paymentInfo_ok(Long id);

    String paymentInfo_timeout(Long id);
}
