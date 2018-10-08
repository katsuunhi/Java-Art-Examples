package ch13;

//demo: use of Stack

import java.util.*;

public class StackTest {
	public static void main(String[] args) {

	Stack<String> stack = new Stack<String>();			//创建一个堆栈
	stack.push("abc");					//入栈
	stack.push("xyz");
	int pos = stack.search("abc");	//返回2
	System.out.println("The position of abc: " + pos);

	boolean empty = stack.empty();		//返回false
	System.out.println("empty of stack: " + empty);

	String obj = stack.peek();			//返回xyz
	
	System.out.println("peek of stack: " + obj);

	String top = stack.pop();			//出栈并返回xyz

	System.out.println("The top of the stack: " + top);
  }
}
