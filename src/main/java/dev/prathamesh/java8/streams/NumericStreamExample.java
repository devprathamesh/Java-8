package dev.prathamesh.java8.streams;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamExample {
	public static void main(String[] args) {
		System.out.printf("Int Stream sum method : %d ", IntStream.rangeClosed(1, 6).sum());
		
		System.out.printf("\nLong Stream sum method : %d ", LongStream.rangeClosed(1, 6).sum());
		
		System.out.printf("\nDouble Stream sum method : %2.2f ", LongStream.rangeClosed(1, 6).asDoubleStream().sum());

	}
}
