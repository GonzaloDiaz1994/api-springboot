package com.example.firstappspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

@SpringBootApplication
public class FirstAppSpringApplication {


    public static void main(String[] args) {
        SpringApplication.run(FirstAppSpringApplication.class, args);
    }


}
