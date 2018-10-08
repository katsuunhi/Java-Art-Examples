package ch14;

class English3 extends Thread {
	public void run() {  			//覆盖run()方法
	 	System.out.print("Java ");
		System.out.print("SE ");
	}
}
class Chinese3 extends Thread {
	public void run() {				//覆盖run()方法
		try {
			  Thread.sleep(500);
			  System.out.print("编程 ");
			  System.out.print("艺术 ");
	 	}
		catch (InterruptedException e) {
			System.out.println(e);
	 	}
	}
}
