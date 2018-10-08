package ch14;

//demo: basic producer-consumer threads implementing Runnable interface

public class ProducerConsumerRunnableApp {
	public static void main(String[] args) {
        Thread producer = new Thread(new Producer1());
        Thread consumer = new Thread(new Consumer1());

        producer.start();
        consumer.start();

        System.out.println("Thread name: " + Thread.currentThread().getName());
	}
}