package com.ranjith.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ranjith.springbootdemo.scopeDemo.PersonDao;

@SpringBootApplication
public class SpringbootApplicationScopeDemo {
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringbootApplicationScopeDemo.class, args);
		
		PersonDao personDao1 = applicationContext.getBean(PersonDao.class);
		PersonDao personDao2 = applicationContext.getBean(PersonDao.class);
		
		
		System.out.println(personDao1);
		System.out.println(personDao2);
		System.out.println(personDao1.getJdbcConnection());
		System.out.println(personDao2.getJdbcConnection());
		
		/*
		 * OUTPUT
		 	com.ranjith.springbootdemo.PersonDao@1fdfafd2
			com.ranjith.springbootdemo.PersonDao@1fdfafd2
			JDBC Connection invoked
			com.ranjith.springbootdemo.JdbcConnection@19fb8826
			JDBC Connection invoked
			com.ranjith.springbootdemo.JdbcConnection@192d74fb
		 */
	}
}
