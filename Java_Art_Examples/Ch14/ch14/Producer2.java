package ch14;

class Producer2 extends Thread {
	private static volatile int productNumber;
	private Shop2 shop;
	public Producer2(Shop2 shop) {
		this.shop = shop;
	}

	public void run() {
		 try {
			  productNumber++;
			  Product product = new Product(productNumber);
			  Thread.sleep((int)(Math.random() * 1000 + 200));
			  shop.producing(product);
			  System.out.println(product + " producted by " + this.getName());
		  }
		  catch (InterruptedException e) {
			   Thread.currentThread().interrupt();
		  }
	}
}

class Consumer2 extends Thread {
	private Shop2 shop;

	public Consumer2(Shop2 shop) {
		this.shop = shop;
	}
	public void run() {				
		Product product;
		    try {
				 Thread.sleep((int)(Math.random() * 1000 + 300));
			     product = shop.consuming();
				 System.out.println(product + " is consumed by " + this.getName());
			 }
			 catch (InterruptedException e) {
				 Thread.currentThread().interrupt();
		  	}
	}
}