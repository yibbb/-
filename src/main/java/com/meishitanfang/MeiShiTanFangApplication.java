package com.meishitanfang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan("com.meishitanfang.mapper")
@SpringBootApplication
public class MeiShiTanFangApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeiShiTanFangApplication.class, args);
    }

}
