package ch14;

//demo: basic threads application using sleep()

public class ThreadSleepApp {
	public static void main(String[] args) {
        Thread english = new English3();
        Thread chinese = new Chinese3();
        chinese.start();
        english.start();
	}
}
