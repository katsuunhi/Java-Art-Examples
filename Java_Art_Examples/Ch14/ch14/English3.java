package ch14;

class English3 extends Thread {
	public void run() {  			//����run()����
	 	System.out.print("Java ");
		System.out.print("SE ");
	}
}
class Chinese3 extends Thread {
	public void run() {				//����run()����
		try {
			  Thread.sleep(500);
			  System.out.print("��� ");
			  System.out.print("���� ");
	 	}
		catch (InterruptedException e) {
			System.out.println(e);
	 	}
	}
}
