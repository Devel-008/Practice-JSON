package com.java8;

import java.util.List;
import java.util.ArrayList;
class GenericClass1<X> {
    <T> GenericClass1(T t) {
        System.out.println(t);
    }
}
public class TypeInference {
    public static void main(String[] args) {
        // In Java 6 and earlier
        List<Integer> list = new ArrayList<>();
        list.add(12);
        for (Integer element : list) {
            System.out.println(element);
        }
        // In Java 7
        List<Integer> list2 = new ArrayList<>(); // Here, diamond is used
        list2.add(12);
        for (Integer element : list2) {
            System.out.println(element);
        }
        GenericClass1<String>gc2 = new GenericClass1<>("Hello");
    }
}
