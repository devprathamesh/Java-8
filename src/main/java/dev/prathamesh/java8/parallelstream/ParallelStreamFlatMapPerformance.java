package dev.prathamesh.java8.parallelstream;

import java.util.List;
import java.util.stream.Collectors;

import dev.prathamesh.java8.data.Student;
import dev.prathamesh.java8.data.StudentDataBase;

public class ParallelStreamFlatMapPerformance {
	
	
	private static List<String> getStudentActivitiesSequential() {
		return StudentDataBase.getStudents().stream().
		map(Student::getActivities).// Stream of List<String>
		flatMap(activities -> activities.stream()).
		distinct().
		collect(Collectors.toList());
	}
	
	private static List<String> getStudentActivitiesParallel() {
		return StudentDataBase.getStudents().stream().parallel().
		map(Student::getActivities).// Stream of List<String>
		flatMap(activities -> activities.stream()).
		distinct().
		collect(Collectors.toList());
	}

	public static void main(String[] args) {
		
		Long startTimeSequential = System.currentTimeMillis();
		System.out.println("Printing Disctinct Activities : " + getStudentActivitiesSequential());
		System.out.println("Duration for sequential flatMap : " + (System.currentTimeMillis() - startTimeSequential));
		
		Long startTimeParallel = System.currentTimeMillis();
		System.out.println("Printing Disctinct Activities : " + getStudentActivitiesParallel());
		System.out.println("Duration for parallel flatMap : " + (System.currentTimeMillis() - startTimeParallel));

	}

}
