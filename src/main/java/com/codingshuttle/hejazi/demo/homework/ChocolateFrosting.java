package com.codingshuttle.hejazi.demo.homework;

import org.springframework.stereotype.Component;

@Component
public class ChocolateFrosting implements Frosting{
    @Override
    public void getFrostingType() {
        System.out.println("Welcome to the Chocolate Frosting shop");
    }
}
