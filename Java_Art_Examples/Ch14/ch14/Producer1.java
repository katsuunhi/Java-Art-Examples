package ch14;
//Demo:  Producer-Consumer threads that implement Runnable interface

class Producer1 implements Runnable {
	private int productNumber = 0;
	private String productInfo = null;


	public void run() {  //
	  while (productNumber < 5) {
		  productNumber++;

		  productInfo = "Product with number " + productNumber + " is produced...";
		  System.out.println(Thread.currentThread().getName() + "\t" + productInfo);
		  Shop.producing();

		  Thread.yield();
	  }
	}
}

class Consumer1 implements Runnable {
	private int consumerNumber = 0;
	private String consumerInfo = null;

	public void run() {				//¸²¸Çrun()·½·¨
		while (consumerNumber < 5) {
		  consumerNumber++;

		  consumerInfo = "Consumer with number " + consumerNumber + " is consuming...";
		  System.out.println(Thread.currentThread().getName() + "\t" + consumerInfo);
		  Shop.consuming();

		  Thread.yield();
	    }
	}
}

