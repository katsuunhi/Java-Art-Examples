package ch13;

//demo: use of HashMap

import java.util.*;

public class EmployeeMapTest {
	public static void main(String[] args) {


	Map<String, String> employeeMap = new HashMap<String, String>();	//创建一个HashMap对象
	employeeMap.put("1110", "朱明");
	employeeMap.put("1115", "刘新");
	employeeMap.put("1112", "王力");
	System.out.println("employeeMap 元素数：" + employeeMap.size());
	System.out.println(employeeMap);

	employeeMap.put("1115", "王力");

  }

}

