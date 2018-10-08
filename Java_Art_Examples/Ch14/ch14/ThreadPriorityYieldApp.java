package ch14;

//demo: basic threads application using priority() and yield()

public class ThreadPriorityYieldApp {
	public static void main(String[] args) {

        Thread english = new English2();
        Thread chinese = new Chinese2();
        english.setPriority(8);
		chinese.setPriority(7);
        english.start();
        chinese.start();
	}
}