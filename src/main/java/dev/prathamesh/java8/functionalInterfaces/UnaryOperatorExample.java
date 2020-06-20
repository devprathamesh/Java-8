package dev.prathamesh.java8.functionalInterfaces;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

    public static void main(String[] args) {

        UnaryOperator<String> concatUnaryOperator =
                input -> input.concat(" Default");

        UnaryOperator<Integer> squareUnaryOperator =
                input -> input * input;

        System.out.println(concatUnaryOperator.apply("Unary Operator"));

        System.out.printf("Finding Square using Unary Operator : %d", squareUnaryOperator.apply(10));
    }
}
