package com.ranjith.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ranjith.springbootdemo.basicDemo.BinarySearchImpl;

@SpringBootApplication
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = SpringApplication.run(SpringbootdemoApplication.class, args);
		BinarySearchImpl bs1 = applicationContext.getBean(BinarySearchImpl.class);
		BinarySearchImpl bs2 = applicationContext.getBean(BinarySearchImpl.class);
		
		System.out.println(bs1);
		System.out.println(bs2);
		
		int result = bs1.binarySearch(new int[] {1, 2, 3, 4}, 3);
		System.out.println(result);
		
	}
}
