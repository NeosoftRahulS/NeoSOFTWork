package com.example;

/* Ways to make an object eligible for garbage collection
   -------------------------------------------------------
   1) Object created inside a method
   2) Reassigning the reference variable
   3) Nullifying the reference variable
   4) Anonymous object

*/
public class WaysForGarbageCollection {

    public static void main(String[] args) {
        objectInsideMethod();
        reassigningVariable();
        referenceNullifying();
        anonymousObject();
    }

    /* Object created inside a method */
    private static void objectInsideMethod() {
        TestDemo.show();
        System.gc();
    }

    /* Reassigning the reference variable */
    private static void reassigningVariable() {
        TestDemo t1 = new TestDemo("t1");
        TestDemo t2 = new TestDemo("t2");

        t1=t2;

        System.gc();
    }

    /* Nullifying the reference variable */
    private static void referenceNullifying() {
        TestDemo t1 = new TestDemo("t1");

        t1 = null;

        System.gc();
    }

    /* Anonymous object */
    private static void anonymousObject() {
        new TestDemo("t1");

        System.gc();
    }
}
