package ch14;

//demo: simple thread test


public class SimpleThreadTest {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());

        Thread thread1 = new HelloThread();
        Thread thread2 = new HelloThread();

        thread1.start();
        thread2.start();
	}
}

class HelloThread extends Thread {

		public void run() {  			//
		 for(int i = 0; i < 10; i++)
		  System.out.println("Hollo world! " + this.getName() + " is running...");
		}
	}