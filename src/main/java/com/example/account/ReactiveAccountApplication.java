package com.example.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ReactiveAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveAccountApplication.class, args);
    }

}
