package ch14;

//demo: basic threads application implementing Runnable

public class RunnableBasicApp {
	public static void main(String[] args) {

        Thread letter = new Thread(new EnglishWord());
        Thread word = new Thread(new ChineseWord());

        letter.start();
        word.start();
	}
}
