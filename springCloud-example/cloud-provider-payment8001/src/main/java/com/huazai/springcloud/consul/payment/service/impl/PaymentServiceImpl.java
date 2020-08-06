package com.huazai.springcloud.consul.payment.service.impl;

import com.huazai.springcloud.commons.entities.Payment;
import com.huazai.springcloud.consul.payment.dao.PaymentDao;
import com.huazai.springcloud.consul.payment.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author pyh
 * @date 2020/7/15 21:27
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
