package com.codingshuttle.hejazi.demo.homework;

import org.springframework.stereotype.Component;

@Component
public class ChocolateSyrup implements Syrup{
    @Override
    public void getSyrupType() {
        System.out.println("Welcome to the Chocolate Syrup shop");
    }
}
