package com.huazai.springcloud.hystrix.payment.service.impl;

import cn.hutool.core.util.IdUtil;
import com.huazai.springcloud.hystrix.payment.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author pyh
 * @date 2020/7/23 22:11
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfoOK(Long id) {
        return "线程：" + Thread.currentThread().getName() + " payment_ok_id" + id + "\t ☺";
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
            })
    @Override
    public String paymentInfoTimeout(Long id) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程：" + Thread.currentThread().getName() + " payment_timeout_id" + id + "\t (┬＿┬)↘";
    }

    //兜底方法
    public String paymentInfoTimeOutHandler(Long id) {
        return "线程池：" + Thread.currentThread().getName() + "   系统繁忙, 请稍候再试  ,id：  " + id + "\t" + "哭了哇呜";
    }

    /*服务熔断*/
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),    // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),    // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),    // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")     // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Long id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功,流水号：" + serialNumber;
    }

    public String paymentCircuitBreakerFallback(Long id) {
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " + id;
    }
}
