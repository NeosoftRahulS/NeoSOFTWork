package com.example;

public class DeepCloneExample implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (DeepCloneExample)super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        DeepCloneExample d1 = new DeepCloneExample();

        DeepCloneExample d2 = (DeepCloneExample) d1.clone();

        System.out.println("Output: False if Deep copy & True if shallow: ");
        System.out.println(d1 == d2);
    }
}
