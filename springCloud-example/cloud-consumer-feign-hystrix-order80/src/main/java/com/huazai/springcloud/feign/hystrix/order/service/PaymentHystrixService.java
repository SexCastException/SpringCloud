package com.huazai.springcloud.feign.hystrix.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author pyh
 * @date 2020/8/8 13:47
 */
@Service
// 使用RequestMapping注解，如果配置了fallback属性，则会报错，还不如直接把全路径配置到具体的方法映射路径中
//@RequestMapping("/payment/hystrix")
@FeignClient(value = "cloud-provider-hystrix-payment", fallback = PaymentHystrixFallbackService.class)
public interface PaymentHystrixService {
    @GetMapping("/payment/hystrix/paymentInfo_ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Long id);

    @GetMapping("/payment/hystrix/paymentInfo_timeout/{id}")
    String paymentInfoTimeout(@PathVariable("id") Long id);
}
