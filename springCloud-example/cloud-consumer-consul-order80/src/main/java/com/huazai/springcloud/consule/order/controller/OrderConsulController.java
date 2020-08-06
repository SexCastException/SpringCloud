package com.huazai.springcloud.consule.order.controller;

import com.huazai.springcloud.commons.entities.CommonResult;
import com.huazai.springcloud.commons.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author pyh
 * @date 2020/7/19 0:59
 */
@RestController
@RequestMapping("/consumer/payment/consul")
@Slf4j
public class OrderConsulController {
    private static final String INVOME_URL = "http://consul-provier-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/paymentConsul")
    public String paymentConsul() {
        return restTemplate.getForObject(INVOME_URL + "/payment/consul/paymentConsul", String.class);
    }

    @GetMapping("/getForEntity/{id}")
    public CommonResult<Payment> getForEntity(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(INVOME_URL + "/payment/consul/paymentConsul", CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }
        return CommonResult.failure();
    }

}
