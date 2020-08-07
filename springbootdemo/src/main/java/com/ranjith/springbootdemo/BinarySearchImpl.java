package com.ranjith.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
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
}
