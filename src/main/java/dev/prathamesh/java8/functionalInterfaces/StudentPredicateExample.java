package dev.prathamesh.java8.functionalInterfaces;

import dev.prathamesh.java8.data.Student;
import dev.prathamesh.java8.data.StudentDataBase;

import java.util.function.Predicate;

public class StudentPredicateExample {

    private static Predicate<Student> is5ThGraderPredicate =
            student -> student.getGrade() > 5;

    private static Predicate<Student> isGPAGreaterThan3_5Predicate =
            student -> student.getGpa() > 3.5;

    private static Predicate<Student> isMaleStudentPredicate =
            student -> student.getGender().equalsIgnoreCase("Male");

    private static void getGrade5Student(){
        StudentDataBase.getStudents().forEach(
                student ->  {
                    if(is5ThGraderPredicate.test(student)){
                        System.out.println(student.getName());
                    }
                }
        );
    }

    private static void getGPA3_5AboveStudent(){
        StudentDataBase.getStudents().forEach(
                student ->  {
                    if(isGPAGreaterThan3_5Predicate.test(student)){
                        System.out.println(student.getName());
                    }
                }
        );
    }

    private static void getMaleStudents(){
        StudentDataBase.getStudents().forEach(
                student ->  {
                    if(isMaleStudentPredicate.test(student)){
                        System.out.println(student.getName());
                    }
                }
        );
    }

    private static void getMaleStudentFromGrade5Above3_5GPA(){
        StudentDataBase.getStudents().forEach(
                student ->  {
                    if(isMaleStudentPredicate.and(is5ThGraderPredicate).and(isGPAGreaterThan3_5Predicate).test(student)){
                        System.out.println(student.getName());
                    }
                }
        );
    }

    public static void main(String[] args) {

        getGrade5Student();

        System.out.printf("\n %s \n", "****************************");

        getGPA3_5AboveStudent();

        System.out.printf("\n %s \n", "****************************");

        getMaleStudents();

        getMaleStudentFromGrade5Above3_5GPA();
    }
}
