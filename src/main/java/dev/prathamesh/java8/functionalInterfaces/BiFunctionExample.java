package dev.prathamesh.java8.functionalInterfaces;

import dev.prathamesh.java8.data.Student;
import dev.prathamesh.java8.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionExample {

    private static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> getStudentNameAndGPAMapBiFunction =
            (students, checkGradePredicate) ->
                    {
                        Map<String, Double> studentNameGPAMap = new HashMap<>();
                        students.forEach(student -> {
                            if(checkGradePredicate.test(student))
                            {
                                studentNameGPAMap.put(student.getName(), student.getGpa());
                            }
                        });

                        return studentNameGPAMap;
                    };

    private static Predicate<Student> checkGradeAbove8Predicate =
            student -> student.getGrade() == 8;

    private static Map<String, Double> getStudentNameGPAMap(){
            return getStudentNameAndGPAMapBiFunction.apply(StudentDataBase.getStudents(), checkGradeAbove8Predicate);
    }

    public static void main(String[] args) {

        System.out.println("Students of Grade 8 and their GPA : " + getStudentNameGPAMap());

    }
}
