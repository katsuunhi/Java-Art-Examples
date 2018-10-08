package ch14;

//Multithreaded Producer-consumer application

public class ProducerConsumerApp {
	public static void main(String[] args) {
		final int SIZE_OF_PRODUCER = 150;
		final int SIZE_OF_CONSUMER = 150;
        Thread producer[] = new Producer2[SIZE_OF_PRODUCER];
        Thread consumer[] = new Consumer2[SIZE_OF_CONSUMER];

        Shop2 shop = new Shop2();

		for(int i = 0; i < producer.length; i++) {
			producer[i] = new Producer2(shop);
        	producer[i].start();
		}
      for(int i = 0; i < consumer.length; i++) {
		  consumer[i] = new Consumer2(shop);
		  consumer[i].start();
	  }
	}
}
