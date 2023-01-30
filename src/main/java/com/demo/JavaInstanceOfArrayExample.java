package com.demo;

public class JavaInstanceOfArrayExample
{
    public static void main(String[] args)
    {
        String[] array = {"a", "b", "c"};
        instanceTester(array);
        arrayTester(array);
    }

    /**
     * A method that tests to see if the given object is
     * an instance of a String.
     */
    static void instanceTester(Object object)
    {
        // see if the object is a String instance
        if (object instanceof String)
            System.out.println("object is a String");
        else
            System.out.println("object is not a String");
    }

    /**
     * A method that test to see if the given object is
     * an instance of a String array.
     */
    static void arrayTester(Object[] objectArray)
    {
        // see if the object is a String array instance
        if (objectArray instanceof String[])
            System.out.println("objectArray is a String array");
        else
            System.out.println("objectArray is not a String array");
    }

}
