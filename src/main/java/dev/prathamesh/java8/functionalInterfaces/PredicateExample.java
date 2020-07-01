package dev.prathamesh.java8.functionalInterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {

    private static List<Integer> inputNumbers = Arrays.asList(34, 56, 186, 203, 78, 475, 306, 373, 243, 447, 886, 997, 999, 1245, 2341);

    public static void main(String[] args) {

        Predicate<Integer> isEvenPredicate = input -> input % 2 == 0;

        Predicate<Integer> isGreaterThan100Predicate = input -> input > 100;

        Predicate<Integer> isLesser1000Predicate = input -> input < 100;

        System.out.println("isEven check : " + isEvenPredicate.test(24));

        inputNumbers.forEach(number -> System.out.println(isEvenPredicate.test(number)));

        inputNumbers.stream().
                filter(isLesser1000Predicate.and(isLesser1000Predicate).and(isEvenPredicate)).
                forEach(System.out::println);

        inputNumbers.stream().
                filter(isLesser1000Predicate.and(isLesser1000Predicate)).
                forEach(System.out::println);

        System.out.printf("%s", inputNumbers.stream().
                filter(isLesser1000Predicate.and(isLesser1000Predicate).and(isEvenPredicate)).
                collect(Collectors.toList()));


    }
}
