package com.java8;
import java.util.function.BiFunction;
interface Sayable{
    void say();
}
interface Sayable1{
    void say();
}
class Arithmetic{
    public static int add(int a, int b){
        return a+b;
    }
    public static float add(int a, float b){
        return a+b;
    }
    public static float add(float a, float b){
        return a+b;
    }
}
interface Messageable{
    Message getMessage(String msg);
}
class Message{
    Message(String msg){
        System.out.print(msg);
    }
}
public class MethodReferences {
    public static void saySomething(){
        System.out.println("Hello, this is static method.");
    }
    public void saySomething1(){
        System.out.println("Hello, this is non-static method.");
    }
    public static void ThreadStatus(){
        System.out.println("Thread is running...");
    }
    public void printnMsg(){
        System.out.println("Hello, this is instance method");
    }
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> adder1 = Arithmetic::add;
        BiFunction<Integer, Float, Float>adder2 = Arithmetic::add;
        BiFunction<Float, Float, Float>adder3 = Arithmetic::add;
        int result1 = adder1.apply(10, 20);
        float result2 = adder2.apply(10, 20.0f);
        float result3 = adder3.apply(10.0f, 20.0f);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        // Referring static method
        Sayable sayable = MethodReferences::saySomething;
        // Calling interface method
        sayable.say();
        Thread t2=new Thread(MethodReferences::ThreadStatus);
        t2.start();
        MethodReferences methodReference = new MethodReferences(); // Creating object
        // Referring non-static method using reference
        Sayable1 sayable1 = methodReference::saySomething1;
        // Calling interface method
        sayable1.say();
        // Referring non-static method using anonymous object
        Sayable1 sayable2 = new MethodReferences()::saySomething1; // You can use anonymous object also
        // Calling interface method
        sayable2.say();
        Thread t3=new Thread(new MethodReferences()::printnMsg);
        t3.start();
        Messageable hello = Message::new;
        hello.getMessage("Hello");
    }
}
