package ch14;

//demo: basic threads application using priority()

public class ThreadPriorityApp {
	public static void main(String[] args) {

        Thread english = new English();
        Thread chinese = new Chinese();
        english.setPriority(10);
		chinese.setPriority(1);
        english.start();
        chinese.start();
	}
}
