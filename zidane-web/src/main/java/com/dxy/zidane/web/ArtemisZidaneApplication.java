package com.dxy.zidane.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.dxy.*"})
@MapperScan("com.dxy.zidane.dao.mapper")
public class ArtemisZidaneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtemisZidaneApplication.class, args);
    }

}
