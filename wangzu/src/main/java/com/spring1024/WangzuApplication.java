package com.spring1024;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.spring1024.dao")
public class WangzuApplication {

    public static void main(String[] args) {
        SpringApplication.run(WangzuApplication.class, args);
    }

}
