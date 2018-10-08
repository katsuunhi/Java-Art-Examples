package ch13;

import java.util.*;

class GenericQueue<E> {
	private LinkedList<E> que = new LinkedList<E>();	//������Ϊ���еļ���
	public void inQue(E item) {
		que.addLast(item);							//����addLast()������Ӳ���
	}
	public E deQue() {								//���Ӳ���
		return que.removeFirst();
	}
	public int size() {								//����size()
		return que.size();
	}
	public boolean empty() {						//����isEmpty()
		return que.isEmpty();
	}
	public String toString() {
		return que.toString();
	}
}
