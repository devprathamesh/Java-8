package dev.prathamesh.java8.methodreference;

import dev.prathamesh.java8.data.Student;

import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceExample {

    private static Supplier<Student> studentSupplier = Student::new;

    private static Function<String, Student> getStudentFunction = Student::new;


    public static void main(String[] args) {
        System.out.println("Usage of ContructorReference using Supplier : " + studentSupplier.get());

        System.out.println("Usage of ContructorReference using Function : " + getStudentFunction.apply("ShreeRam"));

    }
}
