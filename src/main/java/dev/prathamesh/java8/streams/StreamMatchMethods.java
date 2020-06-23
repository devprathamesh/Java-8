package dev.prathamesh.java8.streams;

import dev.prathamesh.java8.data.StudentDataBase;

public class StreamMatchMethods {
	
	private static boolean anyMatchExample() {
		return StudentDataBase.getStudents().stream().anyMatch(student -> student.getGpa() == 3.6);
	}

	private static boolean allMatchExample() {
		return StudentDataBase.getStudents().stream().filter(student -> student.getGrade() == 6).anyMatch(student -> student.getGrade() == 6);
	}
	
	private static boolean noneMatchExample() {
		return StudentDataBase.getStudents().stream().noneMatch(student -> student.getGrade() == 9);
	}


	public static void main(String[] args) {
		System.out.println("Found any student with GPA == 3.6 " + anyMatchExample());
		
		System.out.println("Found all student with Grade == 6 " + allMatchExample());
		
		System.out.println("Found no student with Grade == 9 " + noneMatchExample());
	}

}
