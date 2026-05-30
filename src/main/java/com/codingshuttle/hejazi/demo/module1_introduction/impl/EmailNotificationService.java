package com.codingshuttle.hejazi.demo.module1_introduction.impl;

import com.codingshuttle.hejazi.demo.module1_introduction.NotificationService;
import org.springframework.stereotype.Component;


@Component
//@ConditionalOnProperty(name="notification.type", havingValue="email")
public class EmailNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Email sending..." + message);
    }
}
