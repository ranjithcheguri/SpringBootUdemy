package com.ranjith.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.ranjith.componentscan.ComponentPersonDao;

@SpringBootApplication
@ComponentScan("com.ranjith.componentscan")
public class SpringbootComponentScanDemoApplication {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = SpringApplication.run(SpringbootComponentScanDemoApplication.class, args);
		
		ComponentPersonDao componentPersonDao = applicationContext.getBean(ComponentPersonDao.class);
		
		System.out.println(componentPersonDao.getComponentJdbcConnection());
		
	}
}
