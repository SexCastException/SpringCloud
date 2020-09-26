package com.huazai.springcloud.alibaba.seata.storage.service.service;

/**
 * @author pyh
 * @date 2020/9/23 20:58
 */
public interface StorageService {
    void decrease(Long productId, Integer count);
}
