package com.patch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jackson.jsonpointer.JsonPointerException;

import java.lang.reflect.Array;
import java.util.*;

public class MapSetString {
    public static void main(String[] args) throws JsonProcessingException, JsonPointerException {
        String json_string = "{\r\n\"name\" : \"abc\" ,\r\n\"email id \" : [\"abc@gmail.com\",\"def@gmail.com\",\"ghi@gmail.com\"]\r\n}";
       // System.out.println("Input/Response JSON string:" + json_string);
        ObjectMapper mapper = new ObjectMapper();
//java.util.Map<String, String> map = mapper.readValue(json_string, java.util.Map.class);
        Map<String, Set<String>> listOfMaps = new HashMap<>();
        Set<String> values = new HashSet<>();
        values.add("email id");
        listOfMaps.put("email id", values);
        for (Object keyPointer : listOfMaps.keySet()) {
            listOfMaps.put(String.valueOf(new JsonPointer("/" + keyPointer)), listOfMaps.get(keyPointer));
            System.out.println(listOfMaps);
            System.out.println(keyPointer instanceof String);
            if (keyPointer instanceof String) {
                System.out.println("String");
            }else if(keyPointer instanceof Array) {
                System.out.println("Array");
            }else if (keyPointer instanceof Set<?>){
                System.out.println("Set");
            }else if(keyPointer  instanceof Object){
                System.out.println("Object");
            }else {
                System.out.println("Nothing");
            }
        }
        Collection<?> primaryKeyCollection = listOfMaps.values();
        System.out.println("listOfMaps.values()"+listOfMaps.values());
        System.out.println("listOfMaps.keySet()"+listOfMaps.keySet());
        for (Object primaryKeyObject : primaryKeyCollection) {
                if (primaryKeyObject instanceof String) {
                    System.out.println("String");
                }else if(primaryKeyObject instanceof Array) {
                    System.out.println("Array");
                }else if (primaryKeyObject instanceof Set<?>){
                    System.out.println("Set");
                }else if(primaryKeyObject instanceof Object){
                    System.out.println("Object");
                }else {
                    System.out.println("Nothing");
                }
               // System.out.println("fasterxml JSON string to List of Map:" + listOfMaps);

                /*String json = mapper.writeValueAsString(listOfMaps);
                System.out.println("fasterxml List of Map to JSON string:[compact-print]" + json);

                json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(listOfMaps);
                System.out.println("fasterxml List of Map to JSON string:[pretty-print]" + json);*/


        }
    }
}
