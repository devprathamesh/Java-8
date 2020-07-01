package dev.prathamesh.java8.parallelstream;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamPerformanceIssueExample01 {
	
	private static int parallelStreamProcessingPerformance(Supplier<List<Integer>> integerListSupplier) {
		long startTime = System.currentTimeMillis();
		int result =integerListSupplier.get().stream().parallel().reduce(0, (x, y) -> x + y);
		System.out.println("Duration for the parallel operation of boxed sum : " + (System.currentTimeMillis() - startTime));
		return result;
	}

	private static int sequentialStreamProcessingPerformance(Supplier<List<Integer>> integerListSupplier) {
		long startTime = System.currentTimeMillis();
		int result = integerListSupplier.get().stream().reduce(0, (x, y) -> x + y);
		System.out.println("Duration for sequential operation on boxed sum : " + (System.currentTimeMillis() - startTime));
		return result;
	}
	
	public static void main(String[] args) {
		IntStream.rangeClosed(1, 10000).boxed().collect(Collectors.toList());
		parallelStreamProcessingPerformance(ParallelStreamPerformanceIssueExample01::integerListSuplier);
		sequentialStreamProcessingPerformance(ParallelStreamPerformanceIssueExample01::integerListSuplier);
	}
	
	private static List<Integer> integerListSuplier(){
		return IntStream.rangeClosed(1, 10000).boxed().collect(Collectors.toList());
	}

}
