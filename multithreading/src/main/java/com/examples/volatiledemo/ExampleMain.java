package com.examples.volatiledemo;

public class ExampleMain {

    private final static int noOfThreads = 2;

    public static void main(String[] args) {
        VolatileData data = new VolatileData();
        Thread[] threads = new Thread[noOfThreads];

        for(int i = 0; i < noOfThreads; ++i) {
            threads[i] = new ExampleThread(data);
        }

        for(int i = 0; i < noOfThreads; ++i) {
            threads[i].start();                 //starts all reader threads
        }

        for(int i = 0; i < noOfThreads; ++i) {
            try {
                threads[i].join();              //wait for all threads
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
