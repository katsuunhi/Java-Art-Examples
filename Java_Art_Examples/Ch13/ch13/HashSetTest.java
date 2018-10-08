package ch13;

//demo: use of HashSet

import java.util.*;

public class HashSetTest {
	public static void main(String[] args) {

	HashSet mySet = new HashSet();						//����һ������16�������κ�Ԫ�ص�HashSet����
	HashSet<Character> set = new HashSet<Character>();	//����һ������16���ַ�Ԫ�ؿռ��HashSet����
	HashSet<String> hisSet = new HashSet<String>(30);	//����һ������30��Ԫ�ؿռ��HashSet����
	Collection<Double> yourSet = new HashSet<Double>();	//����һ����Collection���õ��ַ���Ԫ�صļ���
	Collection<?> herSet = new HashSet(mySet);		 	//����һ������mySet��Ԫ�صļ���

	hisSet.add("Wang");
	hisSet.add("45");

	herSet = new HashSet<String>(hisSet);
	System.out.println("herSet = " + hisSet);

	if(!mySet.add("Java"))
		System.out.println("the element is aready in the set��");
	else
		System.out.println("the element has been successfully added into the set ��");
  }

}
