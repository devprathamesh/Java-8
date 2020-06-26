package dev.prathamesh.java8.streams;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import dev.prathamesh.java8.data.Student;
import dev.prathamesh.java8.data.StudentDataBase;

public class StreamsTerminalOperations {

	private static String joiningExample1() {
		return StudentDataBase.getStudents().stream().map(Student::getName).collect(Collectors.joining());

	}

	private static String joiningExample2() {
		return StudentDataBase.getStudents().stream().map(Student::getName).collect(Collectors.joining("-"));

	}

	private static String joiningExample3() {
		return StudentDataBase.getStudents().stream().map(Student::getName).collect(Collectors.joining("-", "[", "]"));
	}

	private static long counting() {
		return StudentDataBase.getStudents().stream().collect(Collectors.counting());
	}

	private static String mapping() {
		return StudentDataBase.getStudents().stream()
				.collect(Collectors.mapping(Student::getName, Collectors.joining("-", "(", ")")));
	}

	private static Optional<Student> minBy() {
		return StudentDataBase.getStudents().stream().collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));
	}

	private static Optional<Student> maxBy() {
		return StudentDataBase.getStudents().stream().collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));
	}

	private static int sumingInt() {
		return StudentDataBase.getStudents().stream().collect(Collectors.summingInt(Student::getNoOfNotebooks));
	}

	private static Double averagingInt() {
		return StudentDataBase.getStudents().stream().collect(Collectors.averagingInt(Student::getNoOfNotebooks));
	}

	private static Map<String, List<Student>> groupingBy01() {
		return StudentDataBase.getStudents().stream().collect(Collectors.groupingBy(Student::getGender));
	}

	private static Map<String, List<Student>> groupingBy02() {
		return StudentDataBase.getStudents().stream()
				.collect(Collectors.groupingBy(student -> student.getGpa() > 4.0 ? "Outstanding" : "Average"));
	}

	private static void groupingByTwoLevel01() {
		System.out.println(StudentDataBase.getStudents().stream()
				.collect(Collectors.groupingBy(Student::getGrade, Collectors.summingInt(Student::getNoOfNotebooks))));
	}

	private static void groupingByTwoLevel02() {
		System.out.println(StudentDataBase.getStudents().stream()
				.collect(Collectors.groupingBy(Student::getGrade, Collectors.groupingBy(Student::getGender))));
	}

	private static void groupingByTwoLevel03() {
		System.out.println(StudentDataBase.getStudents().stream().collect(Collectors.groupingBy(Student::getGrade,
				Collectors.groupingBy(student -> student.getGpa() >= 4.0 ? "Outstanding" : "Average"))));
	}

	private static void groupingByTwoLevel04() {
		System.out.println(StudentDataBase.getStudents().stream()
				.collect(Collectors.groupingBy(Student::getGrade, Collectors.summingInt(Student::getNoOfNotebooks))));
	}

	private static void groupingByThreeArgument01() {
		System.out.println(StudentDataBase.getStudents().stream()
				.collect(Collectors.groupingBy(Student::getName, HashMap::new, Collectors.toList())));
	}
	
	private static void groupingByMaxBy() {
		System.out.println(
		StudentDataBase.getStudents().
		stream().collect(
				Collectors.groupingBy(Student::getGrade, Collectors.maxBy(
						Comparator.comparing(Student::getGpa)))));
	}
	
	private static void groupingByMinBy() {
		System.out.println(
				StudentDataBase.getStudents().
				stream().collect(
						Collectors.groupingBy(Student::getGrade,
								Collectors.minBy(Comparator.comparing(
										Student::getGpa))))	
				);
	}
	
	private static void groupingByMinByCollectingAndThen() {
		System.out.println(
		StudentDataBase.getStudents().stream().
		collect(Collectors.groupingBy(
				Student::getGender,
				Collectors.collectingAndThen(
				Collectors.minBy(
						Comparator.comparing(Student::getGpa)), Optional::get)))
		);		
	}
	
	private static void partitioningBySingleArgument() {
		
		Map<Boolean, List<Student>> partitionedStudents = 
		StudentDataBase.getStudents().
		stream().
		collect(
				Collectors.partitioningBy(student -> student.getGpa() > 4.5)
				);
		
		System.out.println(partitionedStudents);
	}
	
	private static void partitioningByTwoArgument() {
		
		Map<Boolean, Set<Student>> partitionedStudents = 
		StudentDataBase.getStudents().
		stream().
		collect(
				Collectors.partitioningBy(student -> student.getGpa() > 4.5, Collectors.toSet())
				);
		
		System.out.println(partitionedStudents);
	}

	public static void main(String[] args) {
		System.out.println("Joining Example 01 : " + joiningExample1());

		System.out.println("Joining Example 02 : " + joiningExample2());

		System.out.println("Joining Example 02 : " + joiningExample3());

		System.out.println("counting : " + counting());

		System.out.println("mapping : " + mapping());

		System.out.println("minBy : " + (minBy().isPresent() ? minBy().get() : null));

		System.out.println("maxBy : " + (maxBy().isPresent() ? maxBy().get() : null));

		System.out.println("summingInt : " + sumingInt());

		System.out.println("averagingInt : " + averagingInt());

		System.out.println("groupingBy approach 1 : " + groupingBy01());

		System.out.println("groupingBy approach 2 : " + groupingBy02());

		groupingByTwoLevel01();

		groupingByTwoLevel02();

		groupingByTwoLevel03();

		groupingByTwoLevel04();

		groupingByThreeArgument01();
		
		groupingByMaxBy();
		
		groupingByMinBy();	

		groupingByMinByCollectingAndThen();

		partitioningBySingleArgument();
		
		partitioningByTwoArgument();		
	}

}
