package com.ranjith.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ranjith.springbootdemo.cdi.SomeCdiBusiness;
import com.ranjith.springbootdemo.scopeDemo.PersonDao;

@SpringBootApplication
public class SpringbootApplicationCdiDemo {
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringbootApplicationCdiDemo.class, args);
		
		SomeCdiBusiness someCdiBusiness = applicationContext.getBean(SomeCdiBusiness.class);
		
		System.out.println(someCdiBusiness);
		System.out.println(someCdiBusiness.getSomeCdiDao());
	}
}
