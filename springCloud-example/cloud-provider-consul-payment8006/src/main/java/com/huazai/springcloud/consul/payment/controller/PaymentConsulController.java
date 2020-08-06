package com.huazai.springcloud.consul.payment.controller;

import com.huazai.springcloud.commons.entities.CommonResult;
import com.huazai.springcloud.commons.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * @author pyh
 * @date 2020/7/19 1:02
 */
@RestController
@RequestMapping("/payment/consul")
@Slf4j
public class PaymentConsulController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/paymentConsul")
    public String paymentConsul() {
        return "springCloud with consul：" + serverPort + "\t" + UUID.randomUUID();
    }
}
