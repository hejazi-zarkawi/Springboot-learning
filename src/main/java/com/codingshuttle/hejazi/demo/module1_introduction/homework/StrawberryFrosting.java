package com.codingshuttle.hejazi.demo.module1_introduction.homework;

import org.springframework.stereotype.Component;

@Component
public class StrawberryFrosting implements Frosting {
    @Override
    public void getFrostingType() {
        System.out.println("Welcome to the Strawberry Frosting shop");
    }
}
