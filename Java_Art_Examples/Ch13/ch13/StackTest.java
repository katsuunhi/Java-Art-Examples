package ch13;

//demo: use of Stack

import java.util.*;

public class StackTest {
	public static void main(String[] args) {

	Stack<String> stack = new Stack<String>();			//����һ����ջ
	stack.push("abc");					//��ջ
	stack.push("xyz");
	int pos = stack.search("abc");	//����2
	System.out.println("The position of abc: " + pos);

	boolean empty = stack.empty();		//����false
	System.out.println("empty of stack: " + empty);

	String obj = stack.peek();			//����xyz
	
	System.out.println("peek of stack: " + obj);

	String top = stack.pop();			//��ջ������xyz

	System.out.println("The top of the stack: " + top);
  }
}
