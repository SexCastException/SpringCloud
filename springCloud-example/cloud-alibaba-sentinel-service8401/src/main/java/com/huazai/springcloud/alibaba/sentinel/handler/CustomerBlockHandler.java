package com.huazai.springcloud.alibaba.sentinel.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.huazai.springcloud.commons.entities.CommonResult;

/**
 * @author pyh
 * @date 2020/9/11 20:32
 */
public class CustomerBlockHandler {
    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(2020, "自定义限流处理信息....CustomerBlockHandler----1");
    }

    public static CommonResult handleException2(BlockException exception) {
        return new CommonResult(2020, "自定义限流处理信息....CustomerBlockHandler----2");
    }
}
