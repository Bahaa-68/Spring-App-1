package com.guru.firstproject;

import com.guru.firstproject.controllers.DummyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstprojectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FirstprojectApplication.class, args);
		DummyController controller = context.getBean(DummyController.class);
		IO.println(controller.sayHi());
		IO.println(DummyController.class.toString());
	}

}
