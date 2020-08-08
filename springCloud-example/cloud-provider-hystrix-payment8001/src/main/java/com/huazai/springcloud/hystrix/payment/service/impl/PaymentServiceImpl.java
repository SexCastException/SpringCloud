package com.huazai.springcloud.hystrix.payment.service.impl;

import com.huazai.springcloud.hystrix.payment.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

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
}
