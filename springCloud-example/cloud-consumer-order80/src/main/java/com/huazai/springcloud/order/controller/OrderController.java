package com.huazai.springcloud.order.controller;

import com.huazai.springcloud.commons.entities.CommonResult;
import com.huazai.springcloud.commons.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author pyh
 * @date 2020/7/16 21:24
 */
@RestController
@RequestMapping("/consumer/payment")
@Slf4j
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    //    public static final String PAYMENT_URL = "http://localhost:8001/";  // 单机地址
    public static final String PAYMENT_URL = "http://cloud-payment-service/";  // 集群地址，从注册中心通过服务名称找到对应的RPC远程调用地址

    @GetMapping("/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "payment/create", payment, CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> create(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "payment/get/" + id, CommonResult.class);
    }

    // ====================> zipkin+sleuth
    @GetMapping("/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject(PAYMENT_URL + "payment/zipkin", String.class);
        return result;
    }


}
