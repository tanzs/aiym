package me.zhengjie.modules.monitor.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.zhengjie.annotation.AnonymousAccess;
import me.zhengjie.annotation.Limit;
import me.zhengjie.aop.log.Log;
import me.zhengjie.aspect.LimitType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author /程序员XiaoQ
 * 接口限流测试类
 */
@RestController
@RequestMapping("/api/limit")
@Api(tags = "系统：限流测试管理")
public class LimitController {

    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();

    /**
     * 测试限流注解，下面配置说明该接口 60秒内最多只能访问 10次，过滤所有请求
     */
    @GetMapping
    @AnonymousAccess
    @ApiOperation("测试请求限流")
    @Limit(limitType = LimitType.CUSTOMER,key = "testCustomer", period = 60, count = 10,msg = "当前1分钟限制访问10次，请稍后重试！")
    public int testLimit() {
        return ATOMIC_INTEGER.incrementAndGet();
    }

    /**
     * 测试限流注解，下面配置说明该接口每个ip 60秒内最多只能访问 10次
     */
    @GetMapping("/test")
    @AnonymousAccess
    @ApiOperation("测试ip限流")
    @Limit(limitType = LimitType.IP,period = 60, count = 10,msg = "当前1分钟限制访问10次，请稍后重试！")
    public int testLimiting() {
        return ATOMIC_INTEGER.incrementAndGet();
    }
}
