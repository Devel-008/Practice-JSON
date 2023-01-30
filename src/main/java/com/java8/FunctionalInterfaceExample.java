package com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface Doable{
    default void doIt(){
        System.out.println("Do it now");
    }
}

@FunctionalInterface
interface Sayable2 extends Doable{
    void say(String msg);
   /* int hashCode();
    String toString();
    boolean equals(Object obj);*/
}
class Product{
    int id;
    String name;
    float price;
    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public float getPrice() {
        return price;
    }
}

public class FunctionalInterfaceExample implements Sayable2{
    public void say(String msg){
        System.out.println(msg);
    }
    public static void main(String[] args) {
        FunctionalInterfaceExample fie = new FunctionalInterfaceExample();
        fie.say("Hello there");
        FunctionalInterfaceExample fie1 = new FunctionalInterfaceExample();
        fie1.say("Hello hi");
        FunctionalInterfaceExample fie3 = new FunctionalInterfaceExample();
        fie3.say("Hello");
        fie3.doIt();
        List<Product> productsList = new ArrayList<>();
        //Adding Products
        productsList.add(new Product(1,"HP Laptop",25000f));
        productsList.add(new Product(2,"Dell Laptop",30000f));
        productsList.add(new Product(3,"Lenevo Laptop",28000f));
        productsList.add(new Product(4,"Sony Laptop",28000f));
        productsList.add(new Product(5,"Apple Laptop",90000f));
        List<Float> productPriceList = new ArrayList<>();
        for(Product product: productsList){

            // filtering data of list
            if(product.price<30000){
                productPriceList.add(product.price);    // adding price to a productPriceList
            }
        }
        System.out.println(productPriceList);   // displaying data
        List<Float> productPriceList2 =productsList.stream()
                .filter(p -> p.price > 30000)// filtering data
                .map(p->p.price)        // fetching price
                .collect(Collectors.toList()); // collecting as list
        System.out.println(productPriceList2);

        // Stream Iterating Example
        Stream.iterate(1, element->element+1)
                .filter(element->element%5==0)
                .limit(5)
                .forEach(System.out::println);
        List<Product> productsList1 = new ArrayList<>();
        productsList1.add(new Product(1,"HP Laptop",25000f));
        productsList1.add(new Product(2,"Dell Laptop",30000f));
        productsList1.add(new Product(3,"Lenevo Laptop",28000f));
        productsList1.add(new Product(4,"Sony Laptop",28000f));
        productsList1.add(new Product(5,"Apple Laptop",90000f));
        productsList1.stream().filter(product -> product.price == 30000)
                .forEach(product -> System.out.println(product.name));

        Float totalPrice = productsList.stream()
                .map(product->product.price)
                .reduce(0.0f, Float::sum);   // accumulating price
        System.out.println(totalPrice);
        // More precise code
        float totalPrice2 = productsList.stream()
                .map(product->product.price)
                .reduce(0.0f,Float::sum);   // accumulating price, by referring method of Float class
        System.out.println(totalPrice2);
        double totalPrice3 = productsList.stream().mapToDouble(product -> product.price).sum();
        System.out.println(totalPrice3);
        // max() method to get max Product price
        Product productA = productsList.stream().max((product1, product2)->product1.price > product2.price ? 1: -1).get();
        System.out.println(productA.price);
        // min() method to get min Product price
        Product productB = productsList.stream().min((product1, product2)->product1.price > product2.price ? 1: -1).get();
        System.out.println(productB.price);

        // count() Method in Collection
        long count = productsList.stream()
                .filter(product->product.price<30000)
                .count();
        System.out.println(count);
        // Converting product List into Set
        Set<Float> productPriceList1 =
                productsList1.stream()
                        .filter(product->product.price < 30000)   // filter product on the base of price
                        .map(product->product.price)
                        .collect(Collectors.toSet());   // collect it as Set(remove duplicate elements)
        System.out.println(productPriceList1);
        // Converting Product List into a Map
        Map<Integer,String> productPriceMap =
                productsList.stream()
                        .collect(Collectors.toMap(p->p.id, p->p.name));

        System.out.println(productPriceMap);

        //Method Reference in stream
        List<Float> productPriceList3 =
                productsList.stream()
                        .filter(p -> p.price > 30000) // filtering data
                        .map(Product::getPrice)         // fetching price by referring getPrice method
                        .collect(Collectors.toList());  // collecting as list
        System.out.println(productPriceList3);

    }
}
