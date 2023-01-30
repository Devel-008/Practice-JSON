package com.java8;

import java.util.*;
class TestGenerics1{
    public static void main(String[] args){
        ArrayList<String> list=new ArrayList<>();
        list.add("rahul");
        list.add("jai");
//list.add(32);//compile time error

        String s=list.get(1);//type casting is not required
        System.out.println("element is: "+s);

        Iterator<String> itr=list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        Map<Integer,String> map=new HashMap<>();
        map.put(1,"vijay");
        map.put(4,"umesh");
        map.put(2,"ankit");

//Now use Map.Entry for Set and Iterator
        Set<Map.Entry<Integer,String>> set=map.entrySet();

        //no need to typecast
        for (Map.Entry<Integer, String> e : set) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}

