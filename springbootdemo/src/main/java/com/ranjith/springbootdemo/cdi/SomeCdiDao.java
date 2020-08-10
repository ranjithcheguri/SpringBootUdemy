package com.ranjith.springbootdemo.cdi;

import javax.inject.Named;

@Named
public class SomeCdiDao {
	public SomeCdiDao() {
		System.out.println("CDI dao initialized");
	}
}
