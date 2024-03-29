package com.java8;

public class BinaryLiteralsExample {
    public static void main(String[] args) {
        // Binary literal in byte type
        byte b1 = 0b101;    // Using b0, The b can be lower or upper case
        byte b2 = 0B101;    // Using B0
        System.out.println("----------Binary Literal in Byte----------------");
        System.out.println("b1 = "+b1);
        System.out.println("b2 = "+b2);

        // Binary literal in short type
        short s1 = 0b101;   // Using b0, The b can be lower or upper case
        short s2 = 0B101;   // Using B0
        System.out.println("----------Binary Literal in Short----------------");
        System.out.println("s1 = "+s1);
        System.out.println("s2 = "+s2);

        // Binary literal in int type
        int i1 = 0b101;     // Using b0, The b can be lower or upper case
        int i2 = 0B101;     // Using B0
        System.out.println("----------Binary Literal in Integer----------------");
        System.out.println("i1 = "+i1);
        System.out.println("i2 = "+i2);

        // Binary literal in long type
        long l1 = 0b0000011111100001;   // Using b0, The b can be lower or upper case
        long l2 = 0B0000011111100001;   // Using B0
        System.out.println("----------Binary Literal in Long----------------");
        System.out.println("l1 = "+l1);
        System.out.println("l2 = "+l2);


        byte b5 = 5; // a decimal value
        // Using binary of 5
        byte b6 = 0b101;    // using b0, The b can be lower or upper case
        // Declaring negative binary
        byte b3 = -0b101;
        // Using underscore in binary literal
        byte b4 = 0b101_0;
        System.out.println("b5 = "+b5);
        System.out.println("b6 = "+b6);
        System.out.println("b3 = "+b3);
        System.out.println("b4 = "+b4);
        // Check whether binary and decimal are equal
        System.out.println("is b5 and b6 equal: "+(b5==b6));
        // Perform operation on binary value
        System.out.println("b6 + 1 = "+(b6+1));
        // Perform operation on negative binary value
        System.out.println("b3 + 1 = "+(b3+1));
        System.out.println("b4 x 2 = "+(b4*2));
    }
}
