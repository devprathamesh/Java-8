package dev.prathamesh.java8.functionalInterfaces;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

    private static BinaryOperator<Integer> multiplyBinaryOperator =
            (a, b) -> a * b;

    private static Comparator<Integer> integerComparator =
            (a, b) -> a.compareTo(b);

    public static void main(String[] args) {

        System.out.println(multiplyBinaryOperator.apply(5, 10));

        BinaryOperator maxByBinaryOperator = BinaryOperator.maxBy(integerComparator);

        System.out.printf("\nMax of two inputs (%d , %d) : %d ", 123, 321, maxByBinaryOperator.apply(123, 321));

        BinaryOperator minByBinaryOperator = BinaryOperator.minBy(integerComparator);

        System.out.printf("\nMax of two inputs (%d , %d) : %d ", 123, 321, minByBinaryOperator.apply(123, 321));

    }
}
