package com.java8;
import java.util.*;
class A{
    void m(){System.out.println("hello m");}

    @Deprecated
    void n(){System.out.println("hello n");}
}
class TestAnnotation1{
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        ArrayList<String> list=new ArrayList<>();
        list.add("sonoo");
        list.add("vimal");
        list.add("ratan");

        for(Object obj:list)
            System.out.println(obj);

        A a=new A();
        a.n();

    }}

