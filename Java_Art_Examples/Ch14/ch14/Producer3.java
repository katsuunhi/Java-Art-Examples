package ch14;

import java.util.concurrent.*;

class Producer3 extends Thread {					//�������߳�
	private final BlockingQueue<Product> bQue;			//���ýӿ���Ϊ����
	private static int productNumber;
	Producer3(BlockingQueue<Product> que) { bQue = que; }	//������
public void run() {								//����run()
		try {
			 Thread.sleep(1000);
			{ bQue.put(producing()); }			//������Э�����ܵ�put()����������Ԫ��
		} catch (InterruptedException e) { System.out.println(e); }
	}
	Product producing() { 						//������Ʒ
		productNumber++; Product product = new Product(productNumber);
		return product;							//���ز�Ʒ
	}
}
	class  Consumer3 extends Thread { 			//�������߳�
		private final BlockingQueue<Product> bQue;
		Consumer3(BlockingQueue<Product> que) { bQue = que; }
		public void run() {						//����run()
			try {
					consuming(bQue.take());		//������Э�����ܵ�take()��ȡԪ��
			} catch (InterruptedException e) { System.out.println(e); }
		}
		void consuming(Object product) {
			System.out.println(product + " consumed by "+ Thread.currentThread().getName());
		}
}