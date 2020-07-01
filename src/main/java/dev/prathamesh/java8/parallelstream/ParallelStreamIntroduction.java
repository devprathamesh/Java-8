package dev.prathamesh.java8.parallelstream;

import java.util.stream.IntStream;

public class ParallelStreamIntroduction {
	
	public static void main(String[] args) {		
		System.out.println("Number of available processors on the system : " +
		Runtime.getRuntime().availableProcessors());
		
		Long startTimeSequential = System.currentTimeMillis();
		IntStream.rangeClosed(1,  10000).sum();
		System.out.println("Duration to execute sequential sum : " + (System.currentTimeMillis() - startTimeSequential));

		Long startTimeParallel = System.currentTimeMillis();
		IntStream.rangeClosed(1,  10000).parallel().sum(); //Uses fork/join framework introduced in Java 1.7
		System.out.println("Duration to execute parallel sum : " + (System.currentTimeMillis() - startTimeParallel));
	}
}
