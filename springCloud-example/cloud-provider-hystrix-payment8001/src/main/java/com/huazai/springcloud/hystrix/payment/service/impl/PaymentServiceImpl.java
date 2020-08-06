package com.huazai.springcloud.hystrix.payment.service.impl;

import com.huazai.springcloud.hystrix.payment.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author pyh
 * @date 2020/7/23 22:11
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_ok(Long id) {
        return "线程：" + Thread.currentThread().getName() + " payment_ok_id" + id + "\t ☺";
    }

    @Override
    public String paymentInfo_timeout(Long id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程：" + Thread.currentThread().getName() + " payment_timeout_id" + id + "\t (┬＿┬)↘";
    }
}
