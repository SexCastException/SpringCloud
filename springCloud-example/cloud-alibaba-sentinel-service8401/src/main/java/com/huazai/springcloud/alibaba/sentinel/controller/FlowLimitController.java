package com.huazai.springcloud.alibaba.sentinel.controller;

import org.apache.tomcat.jni.Time;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 服务限流
 *
 * @author pyh
 * @date 2020/9/5 12:37
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(1);
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {

        return "------testB";
    }

}
