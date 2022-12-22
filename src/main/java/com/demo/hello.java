package com.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class hello {

    public static void main(String[] args) {

        Set<String> s1 = new HashSet<>();
        s1.add("2");
        s1.add("3");
        s1.add("5");
        s1.add("8");
        s1.add("10");
        s1.add("15");
        Set<String> s2 = new HashSet<>();
        s2.add("7");
        s2.add("8");
        s2.add("10");
        s2.add("12");
        s2.add("13");
        Set<String> s3 = new HashSet<>();
        for(String temp : s1){
            if(!s2.contains(temp)){
                 s3.add(temp);
            }
        }
        System.out.println("s1 - s2 = "+s3);
        for (String temp : s2) {
            if (!s1.contains(temp)) {
                 s3.add(temp);
            }
        }
        System.out.println("Not correct way for s2 - s1 = "+s3);
        Set<String> s4 = new HashSet<>(s1);
        s4.removeAll(s2);
        System.out.println("S1 - S2 := " + s4);
         s4 = new HashSet<>(s2);
        s4.removeAll(s1);
        System.out.println("S2 - S1 := " + s4);

        Set<String> intersection = new HashSet<>(s1);
        intersection.retainAll(s2);
        System.out.println("Intersection := " + intersection);

        intersection = new HashSet<>(s2);
        intersection.retainAll(s1);
        System.out.println("Intersection := " + intersection);

        Map<Set<Integer>, Set<String>> map = new HashMap<>();
        Set<Integer> s = new HashSet<>();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.add(5);
        s.add(6);
        s.add(7);
        s.add(8);
        s.add(9);
        s.add(10);
        Set<String> value = new HashSet<>();
        value.add("ABC");
        value.add("DEF");
        value.add("GHI");
        value.add("JKL");
        value.add("MNO");
        value.add("PQR");
        value.add("STU");
        value.add("VWX");
        value.add("YZa");
        value.add("bcd");

        map.put(s,value);
        int hash = map.hashCode();
        System.out.println("Hash-Code := " + hash);
        System.out.println("Get values with help of s := " + map.get(s));

        Set<Set<Integer>> ss;
        ss = map.keySet();
        System.out.println("KeySet := " + ss);
        System.out.println("SIZE = "+map.size());
        System.out.println("Values := " + map.values());

        String refJsonStr = "Entitlements\":[{\"Application Key\":\"121\",\"Entitlement Type\":\"UD_GROUPS_GROUPS\",\"Entitlement Name\":\"144~Network Security Role\"},{\"Application Key\":\"562\",\"Entitlement Type\":\"UD_GROUPS_GROUPS\",\"Entitlement Name\":\"565~Deployment Owners\"}]}";

        String newJsonStr ="Entitlements\":[{\"Application Key\":\"122\",\"Entitlement Type\":\"UD_GROUPS_GROUPS\",\"Entitlement Name\":\"144~Network Security Role\"},{\"Application Key\":\"562\",\"Entitlement Type\":\"UD_GROUPS_GROUPS\",\"Entitlement Name\":\"565~Deployment Owners\"}]}";

        System.out.println("Comparison := " + refJsonStr.compareTo(newJsonStr));
     }
}
