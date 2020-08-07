package com.ranjith.springbootdemo.basicDemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("quick")
public class QucikSortAlgorithm implements SortAlgorithm{
	public int[] sort(int[] numbers){
		// dummy impl
		return numbers;
	}
}