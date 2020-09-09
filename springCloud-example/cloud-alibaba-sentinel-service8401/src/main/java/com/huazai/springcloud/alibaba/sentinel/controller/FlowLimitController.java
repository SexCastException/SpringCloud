package com.huazai.springcloud.alibaba.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("平均响应时间测试");

        return "------testRt";
    }

    @GetMapping("/testExceptionRate")
    public String testExceptionRate() {
        log.info("异常比例测试");
        int age = 10 / 0;
        return "------testExceptionRate";

    }

    @GetMapping("/testExceptionCount")
    public String testExceptionCount() {
        log.info("异常数测试");
        int age = 10 / 0;
        return "------testExceptionCount";

    }

    @GetMapping("/testHotKey")
    /**
     * value指定的hot key不一定是和请求路径相同，只要是唯一的字符即可，一般情况下和请求路径一致 <br>
     * 1、如果手动抛出 BlockException 类型的异常，重新启动后无论如何都会进入到兜底方法，
     * 但是热启动不会进入兜底方法，直接报错，和其他非 BlockException 异常效果一样，这算不算sentinel的一个bug？
     * 2、配置热点后，尝试在注释中随便添加一些内容目的为了让系统热启动，热启动完成后，当访问接口不满足热点规则后，
     * 由原来调用兜底方法变成了抛出 ClassCastException 异常，为什么热启动后热点规则不生效反而抛出了异常？为什么抛出
     * 的是 ClassCastException 异常？又一个bug？
     */
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) throws AuthorityException {
        //int age = 10/0;
//        throw new AuthorityException(""); // BlockException的子异常
        return "------testHotKey";
    }

    //兜底方法
    public String deal_testHotKey(String p1, String p2, BlockException exception) {
        return "------deal_testHotKey,o(╥﹏╥)o";
    }

}
