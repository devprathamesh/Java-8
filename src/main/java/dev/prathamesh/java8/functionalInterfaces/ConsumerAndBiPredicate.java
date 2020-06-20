package dev.prathamesh.java8.functionalInterfaces;

import dev.prathamesh.java8.data.Student;
import dev.prathamesh.java8.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerAndBiPredicate {

    private BiConsumer<String, List<String>> printStudentNameAndActivitiesConsumer =
            (name, activities) -> {
                System.out.printf("Name : %s and Activities %s does %s", name, name, activities);
            };

    private static BiPredicate<Integer, Double> checkGradeAndGPAPredicate =
            (grade, gpa) -> grade == 6 && gpa > 4.5;


    private Consumer<Student> studentConsumer = student -> {
        if(checkGradeAndGPAPredicate.test(student.getGrade(), student.getGpa())){
            printStudentNameAndActivitiesConsumer.accept(student.getName(), student.getActivities());
        }

    };

    public static void main(String[] args) {
        StudentDataBase.getStudents().forEach(
        new ConsumerAndBiPredicate().studentConsumer);
    }

}
