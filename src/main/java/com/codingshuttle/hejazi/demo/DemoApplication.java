package com.codingshuttle.hejazi.demo;

import com.codingshuttle.hejazi.demo.module1_introduction.homework.Syrup;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

//	@Qualifier("emailNotificationService")
//	@Autowired
//    NotificationService notificationService;
//	Syrup.CakeBaker cb;
//	@Autowired
//    Map<String, NotificationService> notificationService= new HashMap<>();
//	public DemoApplication(
//
//			Syrup.CakeBaker cakebaker) {
//		this.cb = cakebaker;
//	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception{
//		cb.bakeCake();
////		notificationService.send("Hello");
////		for(var notificationService: notificationService.entrySet()){
////			System.out.println(notificationService.getKey());
////			notificationService.getValue().send("Hello");
////		}
//	}
}
