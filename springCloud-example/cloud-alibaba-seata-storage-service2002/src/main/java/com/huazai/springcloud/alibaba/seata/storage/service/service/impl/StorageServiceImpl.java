package com.huazai.springcloud.alibaba.seata.storage.service.service.impl;

import com.huazai.springcloud.alibaba.seata.storage.service.dao.StorageDao;
import com.huazai.springcloud.alibaba.seata.storage.service.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pyh
 * @date 2020/9/23 20:58
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageDao storageDao;

    /**
     * 扣减库存
     *
     * @param productId
     * @param count
     */
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageDao.decrease(productId, count);
        log.info("------->storage-service中扣减库存结束");
    }
}
