package dev.prathamesh.java8.streams;

import java.util.Random;
import java.util.stream.Stream;

public class StreamFactoryMethodsExample {
	
	public static void main(String[] args) {
		
		// of() factory method from Stream
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).forEach(System.out::println);
		
		// interate() factory method from Stream
		Stream.iterate(1, x -> x + 1).limit(10).forEach(System.out::println);
		
		// generate() factory method from Stream
		Stream.generate(() -> new Random().nextInt()).limit(10).forEach(System.out::println);;
	}

}
