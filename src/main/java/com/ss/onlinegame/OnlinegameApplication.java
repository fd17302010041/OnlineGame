package com.ss.onlinegame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages= {"com.ss.onlinegame.service","com.ss.onlinegame.controller","com.ss.onlinegame.config","com.ss.onlinegame.listener","com.ss.onlinegame.mapper"})
@MapperScan("com/ss/onlinegame/mapper")

public class OnlinegameApplication {

    public static void main(String[] args) {

        SpringApplication.run(OnlinegameApplication.class, args);
    }

}
