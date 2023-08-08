package com.examples.waitnotifynotifyall;

public class Consumer extends Thread {
    private Exchange exchange;
    private int number;

    public Consumer(Exchange exchange, int number) {
        this.exchange = exchange;
        this.number = number;
    }

    @Override
    public void run() {
        int value = 0;
        for (int i = 0; i<10; i++) {
            value = exchange.get();
            System.out.println("Consumer #"+ this.number +" got: "+value);
        }
    }
}
