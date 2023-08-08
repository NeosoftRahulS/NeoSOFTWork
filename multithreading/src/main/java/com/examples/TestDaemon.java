package com.examples;

public class TestDaemon extends Thread {

    private static void printAlpha() {
        for(int i=65; i<=90; i++) {
            System.out.println(" "+(char)i);

            try {
                Thread.sleep(100);
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
        System.out.println("In main");

        TestDaemon t1 = new TestDaemon();

        t1.setDaemon(true); //Daemon Thread	[Background Thread] executes as long as foreground threads run
        t1.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(t1.isDaemon()) {
            System.out.println("\n\nIsDaemon: Yes");
        }

        System.out.println("\nout main");
    }

}
