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
	public void run() {				//����run()����
		System.out.print("��� ");
		Thread.yield();

		Time.delay();
	 	System.out.print("���� ");
	}
}