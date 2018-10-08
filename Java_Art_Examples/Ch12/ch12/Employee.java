package ch12;

/**
* 超类<b>Employee</b>。
* 方法<b>getName()</b>以及<b>earnings()</b>用来对子类对象进行多态引用，<br>返回
* 所引用对象的名字和工资。
*
* @author 高永强
* @version 1.1.0
***/
public class Employee {
/**
* 私有实例变量储存姓名。
***/
   private String name;

/**
*创建具有姓名的对象。
*
*@param name A <b>String</b> 对象的姓名。
***/
   public Employee(String name ) {
      this.name = name;
   }
/**
*返回姓名。
*
*@return <b>String</b> for the name.
***/
   public String getName()
      { return name; }
/**
*返回工资。
*
*@return <b>double</b> for the salary.
***/
   public   double earnings(){return 0.0;}
}
