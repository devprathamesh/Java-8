package dev.prathamesh.java8.functionalInterfaces;

import dev.prathamesh.java8.data.Student;
import dev.prathamesh.java8.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerAndPredicate {

    private BiConsumer<String, List<String>> printStudentNameAndActivitiesConsumer =
            (name, activities) -> {
                System.out.printf("Name : %s and Activities %s does %s", name, name, activities);
            };

    private Predicate<Student> getGrade6StudentPredicate =
            student -> student.getGrade() == 6;

    private Predicate<Student> getStudentWithGPAAbove4_5 =
            student -> student.getGpa() > 4.5;

    private Consumer<Student> studentConsumer = student -> {
        if(getGrade6StudentPredicate.and(getStudentWithGPAAbove4_5).test(student)){
            printStudentNameAndActivitiesConsumer.accept(student.getName(), student.getActivities());
        }

    };

    public static void main(String[] args) {
        StudentDataBase.getStudents().forEach(
        new ConsumerAndPredicate().studentConsumer);
    }

}
