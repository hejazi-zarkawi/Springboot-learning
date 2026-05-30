package com.codingshuttle.hejazi.demo.module1_introduction.impl;

import com.codingshuttle.hejazi.demo.module1_introduction.NotificationService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component
//@ConditionalOnProperty(name="notification.type", havingValue="sms")
public class SMSNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("SMS sending..." + message);
    }
}
