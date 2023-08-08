package com.examples.waitnotifynotifyall;

public class ProducerConsumerTest {
    public static void main(String[] args) {
        Exchange exchange = new Exchange();
        Producer producer = new Producer(exchange,1);
        Consumer consumer = new Consumer(exchange,1);
        producer.start();
        consumer.start();
    }
}
