package com.huazai.springcloud.hystrix.payment.controller;

import com.huazai.springcloud.hystrix.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pyh
 * @date 2020/7/23 22:31
 */
@RestController
@RequestMapping("/payment/hystrix")
public class PaymentHystrixController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/paymentInfo_ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Long id) {
        return "result：" + paymentService.paymentInfo_ok(id);
    }

    @GetMapping("/paymentInfo_timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Long id) {
        return "result：" + paymentService.paymentInfo_timeout(id);
    }
}
