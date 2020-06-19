package dev.prathamesh.java8.lambda;

import java.util.Comparator;

public class LamdbaComparator {

    public static void main(String[] args) {

        System.out.println("\n Legacy Implementation of Comparator");


        Comparator<Integer> comparatorLegacy = new Comparator<Integer>() {
            @Override
            public int compare(Integer first, Integer second) {
                return first.compareTo(second);
            }
        };

        System.out.printf("\n Using comparatorLegacy comparatorLegacy.compare(101, 201) : %b", comparatorLegacy.compare(101, 201));

        Comparator<Integer> comparatorLambda01 = (Integer first, Integer second) -> {
            return first.compareTo(second);
        };

        System.out.printf("\n Using comparatorLambda01 comparatorLambda01.compare(101, 201) : %b", comparatorLegacy.compare(101, 201));

        Comparator<Integer> comparatorLambda02 = (first, second) -> first.compareTo(second);


        System.out.printf("\n Using comparatorLambda02 comparatorLambda02.compare(101, 201) : %b", comparatorLegacy.compare(101, 201));

    }

}
