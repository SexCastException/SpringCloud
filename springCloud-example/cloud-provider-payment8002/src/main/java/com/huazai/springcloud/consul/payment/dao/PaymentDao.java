package com.huazai.springcloud.consul.payment.dao;

import com.huazai.springcloud.commons.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author pyh
 * @date 2020/7/15 20:55
 */
@Mapper
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
