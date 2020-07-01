package dev.prathamesh.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsLimitAndSkipExample {
	
	private static List<Integer> integerList = Arrays.asList(12, 25, 45, 67, 54, 78, 88, 96, 100);
	
	private static Optional<Integer> limitFunction() {
		return integerList.stream().limit(2).reduce(Integer::sum);
	}
	
	private static Optional<Integer> skipFunction() {
		return integerList.stream().skip(integerList.size() - 1).reduce(Integer::sum);
	}


	public static void main(String[] args) {
		
		System.out.println("Using limit() from Stream : " + limitFunction().get());
		
		System.out.println("Using skip() from Stream : " + skipFunction().get());
		
	}

}
