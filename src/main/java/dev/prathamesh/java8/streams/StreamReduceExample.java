package dev.prathamesh.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import dev.prathamesh.java8.data.Student;
import dev.prathamesh.java8.data.StudentDataBase;

public class StreamReduceExample {
	
	private static List<Integer> integerList = Arrays.asList(23, 34, 87, 76, 109, 134, 250);
	
	private static Integer calculateSumWithSeed() {
		return integerList.stream().reduce(0, (inputA, inputB) -> inputA + inputB);
	}
	
	private static Optional<Integer> calculateSumWithoutSeed() {
		return integerList.stream().reduce((inputA, inputB) -> inputA + inputB);
	}	

	public static void main(String[] args) {
		System.out.printf("Result of Reduce Operation(Addition) with seed : %d", calculateSumWithSeed());
		
		System.out.printf("\nResult of Reduce Operation(Addition) without Seed : %s", calculateSumWithoutSeed());
		
		if(calculateSumWithoutSeed().isPresent())
			System.out.println("\n Fetch result from Optional : " + calculateSumWithoutSeed().get());
		
		System.out.println("Student with highiest GPA " + getHighestGPAStudent());
	}
	
	private static Optional<Student> getHighestGPAStudent(){
		return StudentDataBase.getStudents().stream().
		reduce((studentOne, studentTwo) -> studentOne.getGpa() > studentTwo.getGpa() ? studentOne : studentTwo);
	}
}
