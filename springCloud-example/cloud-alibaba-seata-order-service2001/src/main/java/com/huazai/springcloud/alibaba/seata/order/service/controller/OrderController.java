package com.huazai.springcloud.alibaba.seata.order.service.controller;

import com.huazai.springcloud.alibaba.seata.order.service.domain.Order;
import com.huazai.springcloud.alibaba.seata.order.service.service.OrderService;
import com.huazai.springcloud.commons.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pyh
 * @date 2020/9/23 20:24
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }

}
