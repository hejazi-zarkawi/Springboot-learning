package com.codingshuttle.hejazi.demo;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

    //@Component
public class PaymentService {
    public void pay(){
        System.out.println("Paying...");
    }

//    @PostConstruct
//    public void after(){
//        System.out.println("After construction");
//    }
//
//    @PreDestroy
//    public void before(){
//        System.out.println("Before destruction");
//    }
}
