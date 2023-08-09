package com.example;

public class ShallowCloneExample {

    public static void main(String[] args) {

        ExampleEntity e1 = new ExampleEntity();

        ExampleEntity e2 = e1;

        System.out.println("Output: False if Deep copy & True if shallow: ");
        System.out.println(e1 == e2);
    }

}
