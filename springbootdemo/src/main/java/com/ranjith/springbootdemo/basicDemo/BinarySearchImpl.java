package com.ranjith.springbootdemo.basicDemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BinarySearchImpl {
	@Autowired					
	@Qualifier("quick")
	SortAlgorithm sortAlgorithm;
	public int binarySearch(int[] numbers, int number) {
		//dummy implementation
		// 1. Sort
		int[] sortedNumbers = sortAlgorithm.sort(numbers);
		System.out.println("Algorithm used is :" + sortAlgorithm);
		// 2. Impl Binary Search
		int index = 0;
		// 3. Return index
		return index;
	}

	@PostConstruct
	public void PostConstruct(){
		System.out.println("post construct called");
	}

	@PreDestroy
	public void PreDestroy(){
		System.out.println("pre destroy called");
	}
}
