package com.huazai.springcloud.alibaba.consumer.nacos.order.service;

import com.huazai.springcloud.commons.entities.CommonResult;
import com.huazai.springcloud.commons.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author pyh
 * @date 2020/9/16 23:04
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
