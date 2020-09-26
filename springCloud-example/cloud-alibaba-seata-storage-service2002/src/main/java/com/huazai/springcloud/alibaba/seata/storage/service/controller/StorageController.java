package com.huazai.springcloud.alibaba.seata.storage.service.controller;

import com.huazai.springcloud.alibaba.seata.storage.service.service.StorageService;
import com.huazai.springcloud.commons.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pyh
 * @date 2020/9/23 20:59
 */
@RestController
public class StorageController {
    @Autowired
    private StorageService storageService;

    //扣减库存
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200,"扣减库存成功！");
    }

    @GetMapping("/testStart")
    public String testStart() {
        return "success";
    }
}
