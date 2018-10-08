package ch14;

//demo: basic threads application

public class ThreadBasicApp {
	public static void main(String[] args) {

		 new English().start();  //create unnamed thread and call start()
	     new Chinese().start();
	}
}