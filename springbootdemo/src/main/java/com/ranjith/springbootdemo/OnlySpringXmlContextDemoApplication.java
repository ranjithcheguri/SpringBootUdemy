package com.ranjith.springbootdemo;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ranjith.springbootdemo.xml.XmlPersonDao;

public class OnlySpringXmlContextDemoApplication {

	public static void main(String[] args) {
		// spring way of creating application context, without spring boot
		try(ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml")){
			System.out.println("beans -> " + Arrays.asList(applicationContext.getBeanDefinitionNames()));
			XmlPersonDao xmlPersonDao = applicationContext.getBean(XmlPersonDao.class);
			System.out.println(xmlPersonDao);
			System.out.println(xmlPersonDao.getXmlJdbcConnection());
		}
		// not req when try is used
//		applicationContext.close();
	}
}