package com.codingshuttle.hejazi.demo.homework;

import org.springframework.stereotype.Component;

@Component
public class StrawberryFrosting implements Frosting{
    @Override
    public void getFrostingType() {
        System.out.println("Welcome to the Strawberry Frosting shop");
    }
}
