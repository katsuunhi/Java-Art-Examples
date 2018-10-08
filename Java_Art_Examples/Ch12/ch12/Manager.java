package ch12;
import java.text.*;

/**
* ��<b>Manager</b>�̳�<b>Employee</b>��
* ��������<b>Manager</b>���󡢷��ع���salary�Լ���������֡�
*
* @author ����ǿ
* @version 1.1.0
***/
public class Manager extends Employee {
/**
* ���ʱ�������ֵ������ڻ����0��
***/
   protected double salary;
/**
*�������������͹��ʵĶ���
*
*@param name A <b>String</b> �����������
*@param salary A <b>double</b> ���ʡ�
***/
   public Manager( String name, double salary) {
      super( name );  // call superclass constructor
      this.salary = salary;
   }
/**
*���ǳ���ķ��������ع��ʡ�
*
*@return <b>double</b> for the salary.
***/
   public double earnings() { return salary; }	//override the method to return salary

/**
*���ǳ���ķ��������ض����������
*
*@return <b>String</b> for the manager's name.
***/
   public String toString() {	//override the method to print the name
      return "Manager: " + getName();
   }
}
