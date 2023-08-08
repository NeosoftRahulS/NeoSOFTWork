/*
   Using Runnable interface
   1)implements Runnable
   2)override run method
   3)create Thread object(pass Runnable class) & invoke start
*/
package com.examples;

public class Test2 implements Runnable {

    private static void printAlpha() {
        System.out.println("Thread start");
        for (int i = 65; i <=90 ; i++) {
            System.out.print(" " + (char)i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };
    }

    @Override
    public void run() {
        printAlpha();
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Test2());
        Thread thread2 = new Thread(new Test2());
        Thread thread3 = new Thread(new Test2());

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
