package ch14;

class Letter {
	public void delay() {
		long n = 500000; //(int)(Math.random()*10000000);

		for(int i = 0; i < n; i++){
			System.out.print("");
		}
	}
	public void display(String letters) {
		System.out.print(letters + " ");
	}

}
