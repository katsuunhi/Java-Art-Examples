package ch14;

class English extends Thread {

	public void run() {  			//
	 System.out.print("Java ");

	Time.delay();

	System.out.print("SE ");
	}
}

class Chinese extends Thread {
	public void run() {				//����run()����
		System.out.print("��� ");
		Time.delay();
	 	System.out.print("���� ");
	}
}