package com.examples.waitnotifynotifyall;

public class Producer extends Thread {
    private Exchange exchange;
    private int number;

    public Producer(Exchange exchange, int number) {
        this.exchange = exchange;
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i<10; i++) {
            exchange.put(i);
            System.out.println("Producer #"+this.number+" put: "+i);
            try {
                sleep((int)(Math.random()*100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
