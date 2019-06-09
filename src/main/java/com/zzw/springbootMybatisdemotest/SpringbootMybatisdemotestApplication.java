package com.zzw.springbootMybatisdemotest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zzw.springbootMybatisdemotest.mapper")
public class SpringbootMybatisdemotestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisdemotestApplication.class, args);
    }

}
