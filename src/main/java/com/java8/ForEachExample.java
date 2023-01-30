package com.java8;

import java.util.ArrayList;
import java.util.List;

public class ForEachExample {
    public static void main(String[] args) {
        List<String> gamesList = new ArrayList<>();
        gamesList.add("Football");
        gamesList.add("Cricket");
        gamesList.add("Chess");
        gamesList.add("Hockey");
        System.out.println("------------Iterating by passing lambda expression--------------");
        gamesList.forEach(System.out::println);
        System.out.println("------------Iterating by passing lambda expression---------------");
        gamesList.stream().forEachOrdered(System.out::println);
        System.out.println("------------Iterating by passing method reference---------------");
        gamesList.stream().forEachOrdered(System.out::println);
    }
}
