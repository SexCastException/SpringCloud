package com.huazai.springcloud.alibaba.seata.order.service.service;

import com.huazai.springcloud.alibaba.seata.order.service.domain.Order;

/**
 * @author pyh
 * @date 2020/9/22 22:56
 */
public interface OrderService {
    void create(Order order);
}
