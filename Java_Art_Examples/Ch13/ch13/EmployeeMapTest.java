package ch13;

//demo: use of HashMap

import java.util.*;

public class EmployeeMapTest {
	public static void main(String[] args) {


	Map<String, String> employeeMap = new HashMap<String, String>();	//����һ��HashMap����
	employeeMap.put("1110", "����");
	employeeMap.put("1115", "����");
	employeeMap.put("1112", "����");
	System.out.println("employeeMap Ԫ������" + employeeMap.size());
	System.out.println(employeeMap);

	employeeMap.put("1115", "����");

  }

}

