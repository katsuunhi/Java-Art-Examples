package ch14;

class English2 extends Thread {

	public void run() {  			//
	 System.out.print("Java ");
	 Thread.yield();

	 Time.delay();

	System.out.print("SE ");
	}
}

class Chinese2 extends Thread {
	public void run() {				//覆盖run()方法
		System.out.print("编程 ");
		Thread.yield();

		Time.delay();
	 	System.out.print("艺术 ");
	}
}