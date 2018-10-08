package ch14;

import java.util.concurrent.*;

public class SynchronousQueueTest {								//测试类
	public static void main(String[] args)  {
		SynchronousQueue<Product> bQue = new SynchronousQueue<Product>();
		Producer3 producer1 = new Producer3(bQue);				//创建两个共享集合的生产者
		Producer3 producer2 = new Producer3(bQue);
		Consumer3 consumer1 = new Consumer3(bQue);				//创建两个共享集合的消费者
		Consumer3 consumer2 = new Consumer3(bQue);
		new Thread(producer1).start();							//可执行状态准备运行
		new Thread(consumer1).start();
		new Thread(consumer2).start();
		new Thread(producer2).start();
	}
}
