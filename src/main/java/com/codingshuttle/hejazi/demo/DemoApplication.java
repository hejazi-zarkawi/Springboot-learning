package com.codingshuttle.hejazi.demo;

import com.codingshuttle.hejazi.demo.homework.CakeBaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

//	@Qualifier("emailNotificationService")
//	@Autowired
//    NotificationService notificationService;
	CakeBaker cb;
//	@Autowired
//    Map<String, NotificationService> notificationService= new HashMap<>();
	public DemoApplication(

			CakeBaker cakebaker) {
		this.cb = cakebaker;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		cb.bakeCake();
//		notificationService.send("Hello");
//		for(var notificationService: notificationService.entrySet()){
//			System.out.println(notificationService.getKey());
//			notificationService.getValue().send("Hello");
//		}
	}
}
