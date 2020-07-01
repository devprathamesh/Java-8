package dev.prathamesh.java8.functionalInterfaces;

import dev.prathamesh.java8.data.Student;
import dev.prathamesh.java8.data.StudentDataBase;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {

    private static Supplier<Student> randomStudentSupplier =
            () -> StudentDataBase.getStudents().get(new Random().nextInt(8));

    public static void main(String[] args) {
        System.out.println("Getting Random Student" + randomStudentSupplier.get());
    }
}
