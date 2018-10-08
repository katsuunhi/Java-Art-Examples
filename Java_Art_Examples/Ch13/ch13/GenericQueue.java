package ch13;

import java.util.*;

class GenericQueue<E> {
	private LinkedList<E> que = new LinkedList<E>();	//创建作为队列的集合
	public void inQue(E item) {
		que.addLast(item);							//调用addLast()进行入队操作
	}
	public E deQue() {								//出队操作
		return que.removeFirst();
	}
	public int size() {								//调用size()
		return que.size();
	}
	public boolean empty() {						//调用isEmpty()
		return que.isEmpty();
	}
	public String toString() {
		return que.toString();
	}
}
