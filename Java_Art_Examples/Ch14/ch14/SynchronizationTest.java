package ch14;

//Demo: thread synchronization test

public class SynchronizationTest {
	static Shared sharedObject = new Shared();
	private static class DemoThread1 extends Thread {
		public void run() {
			synchronized (sharedObject) {
				sharedObject.sorting();
			}
		}
	}
	static class DemoThread2 extends Thread {
		 public void run() {
		 	 synchronized (sharedObject) {
		 		sharedObject.printing();
		 	}
		 }
	}
	public static void main(String[] args) {
         new DemoThread1().run();
         new DemoThread2().run();
	}
}
