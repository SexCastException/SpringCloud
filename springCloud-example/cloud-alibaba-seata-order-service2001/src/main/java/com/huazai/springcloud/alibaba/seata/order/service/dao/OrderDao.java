package com.huazai.springcloud.alibaba.seata.order.service.dao;

import com.huazai.springcloud.alibaba.seata.order.service.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author pyh
 * @date 2020/9/22 22:51
 */
@Mapper
public interface OrderDao {
    //新建订单
    void create(Order order);

    //修改订单状态，从零改为1
    void update(@Param("userId") Long userId, @Param("status") Integer status);

}
