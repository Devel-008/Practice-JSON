package com.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Scanner;
//create class SerializeAndDeserialize
public class SerializeAndDeserialize {
    //main() methods start
    public static void main(String[] args) {
        // create an instance of ObjectMapper class
        ObjectMapper mapper = new ObjectMapper();

        // create Scanner class object
        Scanner sc = new Scanner(System.in);
        // using try-catch
        try {
            College colg;
            String name, university, street, state, city, rank;
            System.out.println("Enter College Name:");
            name = sc.nextLine();
            System.out.println("Enter University Name:");
            university = sc.nextLine();
            System.out.println("Enter Street:");
            street = sc.nextLine();
            System.out.println("Enter City:");
            city = sc.nextLine();
            System.out.println("Enter State:");
            state = sc.nextLine();
            System.out.println("Enter College Rank:");
            rank = sc.nextLine();
            // set values to College  object by using constructor
            colg = new College(name, university, new Address(street, state, city), rank);
            // serialize College using mapper
            String jsonString = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(colg);
            System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //close Scanner class object
        sc.close();
    }
}
//create class College
class College {
    //Creating properties of College class
    public String name;
    protected String university;
    private final Address address;
    private String rank;
    // constructor
    College(String name, String university, Address address, String rank){
        this.name = name;
        this.university = university;
        this.address = address;
        this.rank = rank;
    }
}
//create class Address
class Address {
    public String street;
    public String state;
    public String city;

    Address(String street, String state, String city){
        this.street = street;
        this.state = state;
        this.city = city;
    }
}
