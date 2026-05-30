package com.codingshuttle.hejazi.demo.homework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CakeBaker {
    private final Frosting frosting;
    private final Syrup syrup;

    public CakeBaker(
            @Qualifier("strawberryFrosting") StrawberryFrosting frosting,
            @Qualifier("strawberrySyrup") StrawberrySyrup syrup
    ) {
            this.frosting= frosting;
            this.syrup= syrup;
    }

    public void bakeCake(){
        frosting.getFrostingType();
        syrup.getSyrupType();
    }
}
