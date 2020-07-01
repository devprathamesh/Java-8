package dev.prathamesh.java8.streams;

import java.util.stream.IntStream;

public class StreamAggregateFunctionExample {
	
	public static class CustomObject{
		int input;
		String value;
		
		public CustomObject() {
			super();
		}
		
		public CustomObject(int input, String value) {
			super();
			this.input = input;
			this.value = value;
		}
		
		public String toString(){
			return "[" + this.input + " : " + this.value + "]";
		}
	}

	public static void main(String[] args) {
		System.out.println("Sum aggregate function : " + IntStream.rangeClosed(1, 50).sum());
		
		System.out.println("Min aggregate function : " + IntStream.rangeClosed(1, 50).min());//returns Optional<int>
		
		System.out.println("Min aggregate function fetch : " + IntStream.rangeClosed(1, 50).min().getAsInt());//returns Optional<int>
		
		System.out.println("Max aggregate function : " + IntStream.rangeClosed(1, 50).max());//returns Optional<int>

		System.out.println("Max aggregate function fetch : " + IntStream.rangeClosed(1, 50).max().getAsInt());//returns Optional<int>

		System.out.println("Average aggregate function : " + IntStream.rangeClosed(1, 50).average());//returns Optional<int>
		
		System.out.println("Average aggregate function fetch : " + IntStream.rangeClosed(1, 50).average().getAsDouble());//fetch result as double
		
		IntStream.rangeClosed(1, 10).boxed().forEach(System.out::println);//Converting int to Integer using boxed method of IntStream
		
		IntStream.rangeClosed(1, 10).boxed().mapToInt(Integer::intValue).forEach(System.out::println);//Converting Integer to int using mapToInt
		
		IntStream.rangeClosed(1, 10).mapToObj(in -> new CustomObject(in, "CustomObject"+in)).forEach(System.out::println);;
		
		IntStream.rangeClosed(1, 10).mapToLong(Long::valueOf).forEach(System.out::println);;
		
		IntStream.rangeClosed(1, 10).mapToDouble(Double::valueOf).forEach(System.out::println);
	}
}
