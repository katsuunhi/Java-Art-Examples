package ch14;

import java.util.concurrent.*;

public class SynchronousQueueTest {								//������
	public static void main(String[] args)  {
		SynchronousQueue<Product> bQue = new SynchronousQueue<Product>();
		Producer3 producer1 = new Producer3(bQue);				//�������������ϵ�������
		Producer3 producer2 = new Producer3(bQue);
		Consumer3 consumer1 = new Consumer3(bQue);				//�������������ϵ�������
		Consumer3 consumer2 = new Consumer3(bQue);
		new Thread(producer1).start();							//��ִ��״̬׼������
		new Thread(consumer1).start();
		new Thread(consumer2).start();
		new Thread(producer2).start();
	}
}
