package com.ranjith.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {
	@Autowired							// Autowiring by Name
	SortAlgorithm bubbleSortAlgorithm;	// name directly used, without even creating that variable, spring will take care of it.
	public int binarySearch(int[] numbers, int number) {
		//dummy implementation
		// 1. Sort
		int[] sortedNumbers = bubbleSortAlgorithm.sort(numbers);
		System.out.println("Algorithm used is :" + bubbleSortAlgorithm);
		// 2. Impl Binary Search
		int index = 0;
		// 3. Return index
		return index;
	}
}
