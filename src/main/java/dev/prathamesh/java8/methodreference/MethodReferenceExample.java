package dev.prathamesh.java8.methodreference;

import dev.prathamesh.java8.data.Student;
import dev.prathamesh.java8.data.StudentDataBase;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class MethodReferenceExample {

    private static Consumer<Student> printStudentNameConsumer = student -> System.out.printf("\n %s", student.getName());

    private static Consumer<Student> printStudentMethodReference = System.out::println;

    private static Consumer<Student> printStudentActivitiesMethodReference = Student::printActivites;

    public static void main(String[] args) {

        UnaryOperator<String> concatUnaryOperator =
                string -> string.toUpperCase();

        UnaryOperator<String> concatMethodReference =
                String::toUpperCase;

        System.out.printf("\n Using Lambda concatUnaryOperator %s", concatUnaryOperator.apply("java-8"));

        System.out.printf("\n Using Lambda concatMethodReference %s", concatMethodReference.apply("java-8"));

        System.out.println("\n**********************************************************************");

        StudentDataBase.getStudents().forEach(student -> printStudentNameConsumer.accept(student));

        System.out.println("\n**********************************************************************");

        StudentDataBase.getStudents().forEach(printStudentMethodReference);

        System.out.println("\n**********************************************************************");

        StudentDataBase.getStudents().forEach(System.out::println);

        System.out.println("\n**********************************************************************");

        StudentDataBase.getStudents().forEach(printStudentActivitiesMethodReference);

        System.out.println("\n**********************************************************************");

        StudentDataBase.getStudents().forEach(Student::printActivites);

    }
}
