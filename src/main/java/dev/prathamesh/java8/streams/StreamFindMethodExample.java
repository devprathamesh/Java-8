package dev.prathamesh.java8.streams;

import java.util.Optional;

import dev.prathamesh.java8.data.Student;
import dev.prathamesh.java8.data.StudentDataBase;

public class StreamFindMethodExample {
	
	private static Optional<Student> findAnyStudentWithGPA4_5(){
		return StudentDataBase.getStudents().stream().filter(student -> student.getGpa() == 4.5).findAny();
	}

	
	private static Optional<Student> findFirstStudentWithGPA4_5(){
		return StudentDataBase.getStudents().stream().filter(student -> student.getGpa() == 4.5).findAny();
	}
	public static void main(String[] args) {
		
		System.out.println("Find any student with GPA 4.5 : " + findAnyStudentWithGPA4_5().get());
		
		System.out.println("Find first student with GPA 4.5 : " + findFirstStudentWithGPA4_5().get());

	}

}
