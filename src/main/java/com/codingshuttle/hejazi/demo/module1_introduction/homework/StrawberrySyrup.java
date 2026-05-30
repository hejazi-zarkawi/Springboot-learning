package com.codingshuttle.hejazi.demo.module1_introduction.homework;

import org.springframework.stereotype.Component;

@Component
public class StrawberrySyrup implements Syrup {
    @Override
    public void getSyrupType() {
        System.out.println("Welcome to the Strawberry Syrup shop");
    }
}
