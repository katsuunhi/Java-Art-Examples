package ch14;

import java.util.*;

class Shop2 {
	private volatile LinkedList<Product> productQue = new LinkedList<Product>();

	public synchronized void producing(Product product) {
		while (productQue.size() > 10 ){
			try {
				  wait(100);
				  System.out.println("Products are overstocked.  waiting consumer to buy...");
				  System.out.println("Producer " + Thread.currentThread().getName() + " is wating...");

			  }
			catch (InterruptedException e) {
				  System.out.println(e);
			 }
		}

		notifyAll();
		productQue.addLast(product);
		System.out.println("Number of products avaliable: " + productQue.size());
	}
	public synchronized Product consuming() {

		while (productQue.size() == 0) {
			try {
				 wait();
				 System.out.println("Number of products avaliable: " + productQue.size());
				 System.out.println("Consumer " + Thread.currentThread().getName() + " is wating...");
			 }
			 catch (InterruptedException e) {
				 System.out.println(e);
			 }
		 }
		 return productQue.removeFirst();
	}
	public synchronized int getSize() {
		return productQue.size();
	}
}
