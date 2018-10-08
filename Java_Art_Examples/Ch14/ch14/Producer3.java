package ch14;

import java.util.concurrent.*;

class Producer3 extends Thread {					//生产者线程
	private final BlockingQueue<Product> bQue;			//利用接口作为参数
	private static int productNumber;
	Producer3(BlockingQueue<Product> que) { bQue = que; }	//构造器
public void run() {								//覆盖run()
		try {
			 Thread.sleep(1000);
			{ bQue.put(producing()); }			//调用有协调功能的put()方法增添集合元素
		} catch (InterruptedException e) { System.out.println(e); }
	}
	Product producing() { 						//生产产品
		productNumber++; Product product = new Product(productNumber);
		return product;							//返回产品
	}
}
	class  Consumer3 extends Thread { 			//消费者线程
		private final BlockingQueue<Product> bQue;
		Consumer3(BlockingQueue<Product> que) { bQue = que; }
		public void run() {						//覆盖run()
			try {
					consuming(bQue.take());		//调用有协调功能的take()提取元素
			} catch (InterruptedException e) { System.out.println(e); }
		}
		void consuming(Object product) {
			System.out.println(product + " consumed by "+ Thread.currentThread().getName());
		}
}