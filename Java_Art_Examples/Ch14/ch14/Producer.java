package ch14;

//Demo: Producer-Consumer Threads

class Producer extends Thread {
	public void run() {  //
		  System.out.print(this.getName());
		  System.out.println( " is producing...");
		  Shop.producing();
	}
}

class Consumer extends Thread {
	public void run() {				//¸²¸Çrun()·½·¨
		  System.out.println(this.getName() + " is consuming...");
		  Shop.consuming();
	}
}
