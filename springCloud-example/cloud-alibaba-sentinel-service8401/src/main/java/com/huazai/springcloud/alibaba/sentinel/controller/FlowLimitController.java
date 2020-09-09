package com.huazai.springcloud.alibaba.sentinel.controller;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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

    @GetMapping("/testRt")
    public String testRt() {
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("平均响应时间测试");

        return "------testRt";
    }

    @GetMapping("/testExceptionRate")
    public String testExceptionRate()
    {
        log.info("异常比例测试");
        int age = 10/0;
        return "------testExceptionRate";

    }

    @GetMapping("/testExceptionCount")
    public String testExceptionCount()
    {
        log.info("异常数测试");
        int age = 10/0;
        return "------testExceptionCount";

    }



}
