package dev.prathamesh.java8.functionalInterfaces;

import dev.prathamesh.java8.data.Student;
import dev.prathamesh.java8.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

    public class BiConsumerExample {

        private static BiConsumer<String, List<String>> printStrundAndActivitiesConsumer =
                (student, activities) -> System.out.printf("%s does %s \n" , student, activities);

        private static void printNameAndActivities(){
            StudentDataBase.getStudents().forEach(student -> printStrundAndActivitiesConsumer.accept(student.getName(), student.getActivities()));
        }

        public static void main(String[] args) {
            BiConsumer<String, String> printFullNameBiConsumer = (fName, lName) -> System.out.printf("\n%s %s", fName, lName);

            printFullNameBiConsumer.accept("Prathamesh", "Bandivadekar");

            System.out.printf("\n **************** \n");

            printNameAndActivities();
        }
}
