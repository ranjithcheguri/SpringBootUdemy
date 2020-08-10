package com.ranjith.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.ranjith.springbootdemo.properties.SomeExternalService;
import com.ranjith.springbootdemo.scopeDemo.PersonDao;

@SpringBootApplication
// load properties
@PropertySource("classpath:app.properties")
public class SpringbootApplicationProperiesDemo {
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringbootApplicationProperiesDemo.class, args);
		
		SomeExternalService someExternalService = applicationContext.getBean(SomeExternalService.class);
		
		System.out.println(someExternalService);
		// didnt throw error when @Value is not mapped to properties file, null is printed
		System.out.println(someExternalService.getExternalServiceUrl());
		
	}
}
