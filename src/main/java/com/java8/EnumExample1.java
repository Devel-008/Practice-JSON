package com.java8;

class EnumExample1{
    //defining the enum inside the class
    public enum Season { WINTER, SPRING, SUMMER, FALL }
    //main method
    public static void main(String[] args) {
//traversing the enum
        for (Season s : Season.values())
            System.out.println(s);

        System.out.println("------------------------------------------------------------------------------");
        for (Season s : Season.values()){
            System.out.println(s);
        }
        System.out.println("Value of WINTER is: "+Season.valueOf("WINTER"));
        System.out.println("Index of WINTER is: "+Season.valueOf("WINTER").ordinal());
        System.out.println("Index of SUMMER is: "+Season.valueOf("SUMMER").ordinal());
        System.out.println("------------------------------------------------------------------------------");
        Season s=Season.WINTER;
        System.out.println(s);
    }
}
