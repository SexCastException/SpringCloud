package com.huazai.springcloud.consul.payment.controller;

import com.huazai.springcloud.commons.entities.CommonResult;
import com.huazai.springcloud.commons.entities.Payment;
import com.huazai.springcloud.consul.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author pyh
 * @date 2020/7/15 21:37
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    /**
     * 对于注册进eureka里面的微服务，可以通过服务发现来获得该服务的信息
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0) {
            log.info("订单插入成功");
            return CommonResult.success(result);
        }
        log.info("订单插入失败");
        return CommonResult.failure();
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            payment.setServerPort(serverPort);
            log.info("订单详情查询成功，serverPort：" + serverPort);
            return CommonResult.success(payment);
        }
        log.info("该ID：" + id + "查询不到对应记录");
        return CommonResult.failure();
    }

    @GetMapping("/serverPort")
    public String test() {
        return "test " + serverPort;
    }

    @GetMapping("/discovery")
    public Object discovery() {
        // 获取服务清单列表
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service:" + service);
        }

        //  获取对外暴露的服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    /*@GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serverPort;
    }*/

}
