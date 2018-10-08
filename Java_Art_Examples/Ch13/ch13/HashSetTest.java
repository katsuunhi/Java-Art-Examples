package ch13;

//demo: use of HashSet

import java.util.*;

public class HashSetTest {
	public static void main(String[] args) {

	HashSet mySet = new HashSet();						//创建一个具有16个储存任何元素的HashSet集合
	HashSet<Character> set = new HashSet<Character>();	//创建一个具有16个字符元素空间的HashSet集合
	HashSet<String> hisSet = new HashSet<String>(30);	//创建一个具有30个元素空间的HashSet集合
	Collection<Double> yourSet = new HashSet<Double>();	//创建一个由Collection引用的字符串元素的集合
	Collection<?> herSet = new HashSet(mySet);		 	//创建一个含有mySet各元素的集合

	hisSet.add("Wang");
	hisSet.add("45");

	herSet = new HashSet<String>(hisSet);
	System.out.println("herSet = " + hisSet);

	if(!mySet.add("Java"))
		System.out.println("the element is aready in the set…");
	else
		System.out.println("the element has been successfully added into the set …");
  }

}
