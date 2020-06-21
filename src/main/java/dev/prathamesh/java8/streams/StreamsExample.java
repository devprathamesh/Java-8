package dev.prathamesh.java8.streams;

import dev.prathamesh.java8.data.Student;
import dev.prathamesh.java8.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamsExample {
    private static Function<Student, String> getNameFunction = student ->
            student.getName();

    private static Function<Student, List<String>> getActivitiesFunction = student ->
            student.getActivities();

    private static Predicate<Student> studentGPAPredicate = student ->
            student.getGpa() > 4.5;

    public static void main(String[] args) {
        /*
        System.out.println(StudentDataBase.getStudents().
                stream().collect(Collectors.
                toMap(getNameFunction, getActivitiesFunction)));

        System.out.println(StudentDataBase.getStudents().
                stream().collect(Collectors.
                toMap(Student::getName, Student::getActivities)));

        System.out.println(StudentDataBase.getStudents().
                parallelStream().collect(Collectors.
                toMap(getNameFunction, getActivitiesFunction)));

        System.out.println(StudentDataBase.getStudents().
                stream().filter(student -> student.getGrade() == 8).collect(Collectors.
                toMap(getNameFunction, getActivitiesFunction)));

        System.out.println(StudentDataBase.getStudents().
                stream().filter(studentGPAPredicate.and(student -> student.getGrade() == 8))
                .collect(Collectors.
                toMap(getNameFunction, getActivitiesFunction)));

        System.out.println(StudentDataBase.getStudents().
                stream().filter(studentGPAPredicate.
                and(student -> student.getGrade() == 8)).peek(System.out::println)
                .collect(Collectors.
                        toMap(getNameFunction, getActivitiesFunction)));


        //Streams allow interation only once. We can't re-use the stream.
        // We get errors on reiteration.

        Stream<Student> studentStream = StudentDataBase.getStudents().stream();

        studentStream.forEach(System.out::println); // Iteration One - Success

        //studentStream.forEach(System.out::println); // Iteration Two - Failed
        //Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed

        //map function example
        System.out.printf("list of Student names using map function \n%s ", StudentDataBase.getStudents().stream().map(Student::getName).collect(toList()));

        System.out.printf("list of Student names toUpperCase using map function \n%s ", StudentDataBase.getStudents().stream().map(Student::getName).map(String::toUpperCase).collect(toList()));

        //Usage of flatMap
        printStudentActivities();

        //Usage of distinct()
        System.out.printf("\nList of Distinct Activites : %s", getDisctinctActivites());

        //Usage of count()
        System.out.printf("\nCount of Distinct Activites : %s", countDistinctActivities());

        //Usage of sorted() - Default
        System.out.printf("\nSorted List of Distinct Activites : %s", getActivitiesinSortedOrder());

        //Usage of sorted(comparator) - ByName
        System.out.printf("\nSorted List of Students byName : %s", getStudentsSortedByName());

        //Usage of sorted(comparator) - byGPA - ASC
        System.out.printf("\nSorted List of Students byGPA Asc : %s", getStudentsSortedByGPAAsc());

        //Usage of sorted(comparator) - byGPA - Desc
        System.out.printf("\nSorted List of Students byGPA Desc : %s", getStudentsSortedByGPADesc());

        */
        //Usage of filter(Predicate)
        System.out.printf("\nList of Students GPA > 4 Desc : %s", filterStudentsSortedByGPA());
    }

    private static void printStudentActivities() {

        List<String> listofStudentActivities = StudentDataBase.getStudents().stream().map(Student::getActivities).flatMap(List::stream).collect(toList());
        System.out.println("\nUsing flatMap() : " + listofStudentActivities);
    }

    private static List<String> getDisctinctActivites(){
        return StudentDataBase.getStudents().stream().
                map(Student::getActivities).
                flatMap(List::stream).
                distinct().
                collect(toList());
    }

    private static Long countDistinctActivities(){
        return StudentDataBase.getStudents().stream().map(Student::getActivities).distinct().count();
    }

    private static List<String> getActivitiesinSortedOrder(){
        List<String> listofSortedActivities = StudentDataBase.
                getStudents().stream().
                map(Student::getActivities).
                flatMap(List::stream).
                distinct().sorted().collect(toList());
        return  listofSortedActivities;
    }

    private static List<Student> getStudentsSortedByName(){
        return StudentDataBase.getStudents().stream().sorted(Comparator.comparing(Student::getName)).collect(toList());
    }

    private static List<Student> getStudentsSortedByGPAAsc(){
        return StudentDataBase.getStudents().stream().sorted(Comparator.comparing(Student::getGpa)).collect(toList());
    }

    private static List<Student> getStudentsSortedByGPADesc(){
        return StudentDataBase.getStudents().stream().sorted(Comparator.comparing(Student::getGpa).reversed()).collect(toList());
    }

    private static List<Student> filterStudentsSortedByGPA(){
        return StudentDataBase.getStudents().stream().filter(student -> student.getGpa() > 4).collect(toList());
    }
}