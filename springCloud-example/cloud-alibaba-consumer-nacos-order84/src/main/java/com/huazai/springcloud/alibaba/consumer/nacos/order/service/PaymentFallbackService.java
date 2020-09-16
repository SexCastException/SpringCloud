package com.huazai.springcloud.alibaba.consumer.nacos.order.service;

import com.huazai.springcloud.commons.entities.CommonResult;
import com.huazai.springcloud.commons.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author pyh
 * @date 2020/9/16 23:05
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(4444, "服务降级返回,---PaymentFallbackService", new Payment(id, "errorSerial"));
    }

}
