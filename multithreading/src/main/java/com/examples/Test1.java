/*
   Using Thread Class
   -------------------
   1)extends Thread
   2)override run method
   3)create object & invoke start
 */
package com.examples;

public class Test1 extends Thread {

    private static void printAlpha()  {
        System.out.println("New Thread start");

        for (int i=65; i<=90; i++) {
            System.out.println(" "+(char)i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void run() {
        printAlpha();
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Test1 test2 = new Test1();
        Test1 test3 = new Test1();

        test1.run(); //Thread-0
        test2.run(); //Thread-1
        test3.run(); //Thread-2
    }

}
