package dev.prathamesh.java8.streams;

import java.util.Optional;

import dev.prathamesh.java8.data.Student;
import dev.prathamesh.java8.data.StudentDataBase;

public class StreamMapFilterReduceExample {
	
	private static Optional<Integer> getTotalConsumables() {
		return StudentDataBase.getStudents().stream() //Stream<Student>
		.map(Student::getNoOfNotebooks).reduce((noA, noB) -> noA + noB);
	}
	
	private static Optional<Integer> getTotalConsumablesForGrade6() {
		return StudentDataBase.getStudents().stream() //Stream<Student>
		.filter(student -> student.getGrade() == 6).map(Student::getNoOfNotebooks).reduce((noA, noB) -> noA + noB);
	}
	
	private static Optional<Integer> getTotalConsumablesForGrade6UsingInteger() {
		return StudentDataBase.getStudents().stream() //Stream<Student>
		.filter(student -> student.getGrade() == 6).map(Student::getNoOfNotebooks).reduce(Integer::sum);
	}


	public static void main(String[] args) {		
		
		
		System.out.printf("\nTotal Number of Books %d : ", getTotalConsumables().get());
		
		System.out.printf("\nTotal Number of Books for Grade 6 Version 1 : %d ", getTotalConsumablesForGrade6().get());
		
		System.out.printf("\nTotal Number of Books for Grade 6 Version 2 : %d ", getTotalConsumablesForGrade6UsingInteger().get());
	}

}
