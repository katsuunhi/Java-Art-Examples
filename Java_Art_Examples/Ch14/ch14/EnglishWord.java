package ch14;

class EnglishWord extends Letter implements Runnable {

	public void run() {  			//
	display("Java ");

	delay();

	display("SE ");
	}
}

class ChineseWord extends Letter implements Runnable {
	public void run() {				//����run()����
		display("��� ");
		delay();
	 	display("���� ");
	}
}
