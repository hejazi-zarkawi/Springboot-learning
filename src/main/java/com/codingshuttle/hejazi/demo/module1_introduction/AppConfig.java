package com.codingshuttle.hejazi.demo.module1_introduction;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    PaymentService payment(){
        return new PaymentService();
    }
}
