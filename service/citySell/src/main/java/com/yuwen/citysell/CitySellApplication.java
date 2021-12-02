package com.yuwen.citysell;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yuwen
 */
@SpringBootApplication
@MapperScan(basePackages = "com.yuwen.citysell.dao")
public class CitySellApplication {

    public static void main(String[] args) {
        SpringApplication.run(CitySellApplication.class, args);
    }
}
