package ch12;

/**
* ����<b>Employee</b>��
* ����<b>getName()</b>�Լ�<b>earnings()</b>���������������ж�̬���ã�<br>����
* �����ö�������ֺ͹��ʡ�
*
* @author ����ǿ
* @version 1.1.0
***/
public class Employee {
/**
* ˽��ʵ����������������
***/
   private String name;

/**
*�������������Ķ���
*
*@param name A <b>String</b> �����������
***/
   public Employee(String name ) {
      this.name = name;
   }
/**
*����������
*
*@return <b>String</b> for the name.
***/
   public String getName()
      { return name; }
/**
*���ع��ʡ�
*
*@return <b>double</b> for the salary.
***/
   public   double earnings(){return 0.0;}
}
