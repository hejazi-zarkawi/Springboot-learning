package com.codingshuttle.hejazi.demo.module1_introduction.homework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public interface Syrup {
    void getSyrupType();

    @Component
    class CakeBaker {
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

    @Component
    class ChocolateFrosting implements Frosting{
        @Override
        public void getFrostingType() {
            System.out.println("Welcome to the Chocolate Frosting shop");
        }
    }
}
