package com.example.ucams;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/example/ucams/mapper")
public class UcamsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UcamsApplication.class, args);
    }

}
