package dev.prathamesh.java8.functionalInterfaces;

import java.util.function.Function;

public class FunctionExample {

    private static Function<String, String> getStringFirstFunction =
            inputString -> "Hello ".concat(inputString);

    private static Function<String, String> getStringSecondFunction =
            inputString -> "Super ".concat(inputString);

    public static void main(String[] args) {

        System.out.println(getStringFirstFunction.apply("World!"));

        System.out.println(getStringFirstFunction.andThen(getStringSecondFunction).apply("World"));

        System.out.println(getStringFirstFunction.compose(getStringSecondFunction).apply("World"));

    }
}
