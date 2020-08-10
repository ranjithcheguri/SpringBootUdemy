package com.ranjith.springbootdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ranjith.springbootdemo.basicDemo.BinarySearchImpl;

@Configuration
@ComponentScan
public class OnlySpringDemoApplication {

	public static void main(String[] args) {
		// spring way of creating application context, without spring boot
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(OnlySpringDemoApplication.class);
		BinarySearchImpl bs1 = applicationContext.getBean(BinarySearchImpl.class);
		System.out.println(bs1);
		int result = bs1.binarySearch(new int[] {1, 2, 3, 4}, 3);
		System.out.println(result);
	}
}
