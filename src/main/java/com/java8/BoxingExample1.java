package com.java8;

class BoxingExample1 {
    static void m(int i){System.out.println("int");}
    static void m(Integer i){System.out.println("Integer");}
    public static void main(String[] args) {
        Integer a2 = 50;//Boxing

        int a3 = 5;//Boxing

        System.out.println(a2 + " " + a3);
        Integer i = 50;
        int a = i;

        System.out.println(a);
        Integer i1 = 50;

        if (i1 < 100) {            //unboxing internally
            System.out.println(i1);
        }
        short s=30;
        m(s);
    }
}