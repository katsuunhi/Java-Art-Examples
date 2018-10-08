package ch14;

class EnglishWord extends Letter implements Runnable {

	public void run() {  			//
	display("Java ");

	delay();

	display("SE ");
	}
}

class ChineseWord extends Letter implements Runnable {
	public void run() {				//覆盖run()方法
		display("编程 ");
		delay();
	 	display("艺术 ");
	}
}
