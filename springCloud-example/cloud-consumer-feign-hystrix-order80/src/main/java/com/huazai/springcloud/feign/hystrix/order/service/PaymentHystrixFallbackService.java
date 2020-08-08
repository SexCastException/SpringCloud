package com.huazai.springcloud.feign.hystrix.order.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author pyh
 * @date 2020/8/8 17:38
 */
@Service
public class PaymentHystrixFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfoOK(Long id) {
        return "PaymentHystrixFallbackService fallback method--paymentInfoOK--(┬＿┬)";
    }

    @Override
    public String paymentInfoTimeout(Long id) {
        return "PaymentHystrixFallbackService fallback method---paymentInfoOK--(┬＿┬)";
    }
}
