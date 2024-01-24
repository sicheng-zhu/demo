package com.atguigu.gmall;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1、导入依赖：
 *   1)、导入dubbo-starter
 *   2)、导入dubbo的其它依赖 (curator)
 */
@EnableDubbo // 开启基于注解的dubbo功能
@SpringBootApplication
public class BootUserServiceProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootUserServiceProviderApplication.class, args);
    }
}
