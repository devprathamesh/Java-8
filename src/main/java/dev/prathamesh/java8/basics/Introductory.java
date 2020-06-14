package dev.prathamesh.java8.basics;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class Introductory {
    public static void main(String[] args) {

        int sum = 0;

        for(int i = 0; i <=100;i++){
            sum += i;
        }

        System.out.printf("\n Sum Imperative Style : " + sum);

        System.out.printf("\n Sum Declarative Style : " + IntStream.rangeClosed(0, 100).sum());

        List<Integer> intList = Arrays.asList(0, 1, 2, 2, 3, 4, 5, 6, 6);

        System.out.printf("\n Distinct List Declarative Style : %s", intList.stream().distinct().collect(Collectors.toList()));

    }
}
