package com.huazai.springcloud.alibaba.seata.storage.service.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author pyh
 * @date 2020/9/23 20:55
 */
@Mapper
public interface StorageDao {
    /**
     * 扣减库存信息
     *
     * @param productId
     * @param count
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
