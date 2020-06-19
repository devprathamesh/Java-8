package dev.prathamesh.java8.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDataBase {

    public static List<Student> getStudents(){
        List<Student> studentList = new ArrayList<Student>();

        studentList.add(new Student("Prathamesh", 6, 4.9, "Male", Arrays.asList("Running", "Yoga")));
        studentList.add(new Student("Pradnya", 8, 4.9, "Female", Arrays.asList("Cycling", "Yoga")));
        studentList.add(new Student("Prabodh", 5, 4.7, "Male", Arrays.asList("Swimming", "Cycling")));

        studentList.add(new Student("Jack", 5, 4.6, "Male", Arrays.asList("Skiing", "Karate")));
        studentList.add(new Student("Jill", 8, 3.9, "Female", Arrays.asList("Karate", "Yoga")));
        studentList.add(new Student("John", 6, 3.5, "Male", Arrays.asList("Karat", "Running")));

        studentList.add(new Student("Brian", 5, 4.6, "Male", Arrays.asList("Dance", "Karate")));
        studentList.add(new Student("Susan", 8, 3.9, "Female", Arrays.asList("Skiing", "Jogging")));
        studentList.add(new Student("Derek", 6, 3.5, "Male", Arrays.asList("Swimming", "Running")));

        return studentList;
    }
}
