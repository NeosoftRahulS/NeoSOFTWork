package com.example;

public class TestDemo {

    String objName;

    public TestDemo(String objName) {
        this.objName=objName;
    }

    public static void show() {
        TestDemo t1 = new TestDemo("t1");
        display();
    }

    public static void display() {
        TestDemo t2 = new TestDemo("t2");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.objName+" Successfully garbage collected");
    }
}
