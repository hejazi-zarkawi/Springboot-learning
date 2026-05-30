package com.codingshuttle.hejazi.demo.impl;

import com.codingshuttle.hejazi.demo.NotificationService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
