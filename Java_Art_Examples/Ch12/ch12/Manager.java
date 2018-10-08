package ch12;
import java.text.*;

/**
* 类<b>Manager</b>继承<b>Employee</b>。
* 用来创建<b>Manager</b>对象、返回工资salary以及对象的名字。
*
* @author 高永强
* @version 1.1.0
***/
public class Manager extends Employee {
/**
* 工资变量。其值必须大于或等于0。
***/
   protected double salary;
/**
*创建具有姓名和工资的对象。
*
*@param name A <b>String</b> 对象的姓名。
*@param salary A <b>double</b> 工资。
***/
   public Manager( String name, double salary) {
      super( name );  // call superclass constructor
      this.salary = salary;
   }
/**
*覆盖超类的方法，返回工资。
*
*@return <b>double</b> for the salary.
***/
   public double earnings() { return salary; }	//override the method to return salary

/**
*覆盖超类的方法，返回对象的姓名。
*
*@return <b>String</b> for the manager's name.
***/
   public String toString() {	//override the method to print the name
      return "Manager: " + getName();
   }
}
