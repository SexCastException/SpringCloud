package com.huazai.springcloud.feign.hystrix.order.controller;

import com.huazai.springcloud.feign.hystrix.order.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pyh
 * @date 2020/8/8 14:09
 */
@RestController
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
@RequestMapping("/consumer/payment/hystrix")
@Slf4j
public class PaymentHystrixController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/ok/{id}")
    @HystrixCommand
    public String paymentInfoOK(@PathVariable("id") Long id) {
        String result = paymentHystrixService.paymentInfoOK(id);
        log.info("*******result:" + result);
        if (true) {
            throw new RuntimeException("手动抛出异常");
        }
        return result;
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
            })
    @GetMapping("/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Long id) {
        String result = paymentHystrixService.paymentInfoTimeout(id);
        log.info("*******result:" + result);
        return result;
    }

    //兜底方法
    public String paymentInfoTimeOutHandler(Long id) {
        return "我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
    }

    public String paymentGlobalFallbackMethod() {
        return "针对单个controller配置的默认全局服务降级方法";
    }

}
