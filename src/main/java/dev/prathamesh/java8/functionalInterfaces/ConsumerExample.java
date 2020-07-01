package dev.prathamesh.java8.functionalInterfaces;

import dev.prathamesh.java8.data.Student;
import dev.prathamesh.java8.data.StudentDataBase;

import java.util.function.Consumer;

public class ConsumerExample {

    static Consumer<Student> printNameConsumer = student -> System.out.println(student.getName());
    static Consumer<Student> printActivitiesConsumer = student -> System.out.println(student.getActivities());


    private static void printName(){
        StudentDataBase.getStudents().forEach(printNameConsumer);
    }

    private static void printActivities(){
        StudentDataBase.getStudents().forEach(printActivitiesConsumer);
    }

    private static void printNameAndThenActivities(){
        StudentDataBase.getStudents().forEach(printNameConsumer.andThen(printActivitiesConsumer));
    }

    public static void main(String[] args) {

        Consumer<Integer> squareConsumer = number -> System.out.printf("Square of input %d : %d ", number, number * number);
        squareConsumer.accept(10);

        System.out.printf("\n");

        printName();

        System.out.printf("\n");

        printActivities();

        System.out.printf("\n");

        printNameAndThenActivities();
    }
}
