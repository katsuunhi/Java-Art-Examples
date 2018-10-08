package ch12;
//Demo: use of varargs and enum types with static import for sport car info

import static ch12.SportCarType.*;
import static ch12.ColorType.*;
import static ch12.PaymentType.*;

import java.text.DecimalFormat;


public class VarargsApp {
 public static void main( String args[] ) {

	 SportCars yourCar = new SportCars("P");
	 System.out.println("��Ҫ���ܳ���Ϣ��\n" + yourCar + "\n");

	 SportCars myCar = new SportCars("J", "S");
	 System.out.println("��Ҫ���ܳ���Ϣ��\n" + myCar + "\n");

	 SportCars herCar = new SportCars("F", "B", "C");
	 System.out.println("��Ҫ���ܳ���Ϣ��\n" + herCar + "\n");


	}
}

class SportCars {

	SportCarType type;
	ColorType color;
	PaymentType payment;

	public SportCars (String...choices) {

		type = null;
		color = null;
		payment = null;

      processInfo(choices);
 }

 private void processInfo(String[] choices) {


	   if (choices.length == 1) {
	      processType(choices[0]);

	    }
	   else if (choices.length == 2) {
	     processType(choices[0]);
	     processColor(choices[1]);
 		}
	   else if (choices.length == 3) {
		 processType(choices[0]);
		 processColor(choices[1]);
	     processPayment(choices[2]);
	   }

 }
private void processType(String type) {
	 if (type.equals("P"))
	 	this.type = PORSCHE;
	 else if (type.equals("F"))
	    this.type = FERRARI;
	 else if(type.equals("J"))
	 	this.type = JAGUAR;
}


private void processColor(String color) {
	if (color.equals("W"))
	   this.color =  WHITE;
	else if (color.equals("S"))
	   this.color =  SILVER;
	else if(color.equals("B"))
	   this.color =  BLACK;
}

private void processPayment(String payment) {
	if (payment.equals("C"))
		this.payment =  CASH;
	else if (payment.equals("CC"))
		this.payment =  CREDIT;
	else if(payment.equals("L"))
	   this.payment =  LOAN;

 }
 public String toString() {
		DecimalFormat dollar = new DecimalFormat("#,##0.00");
		String info = null;

      if (color == null)
			info = type.getMake() + "\n�۸�$" + dollar.format(type.getPrice());
		else if (payment == null)
		    info = type.getMake() + "\n�۸�$" + dollar.format(type.getPrice()) + "\n"
		                             + color.getDescription();
		else
		    info = type.getMake() + "\n�۸�$" + dollar.format(type.getPrice()) + "\n"
		                               + color.getDescription() + "\n" + payment.getPayment();

		return info;
	 }
}

enum ColorType {
	WHITE {String getDescription(){
		        return "��ǳ�ס����ס������׿�ѡ";
			}
	},
	SILVER {String getDescription() {
				return "�����ס����ҡ�����ɫ��ѡ";
			}
	},

	BLACK {String getDescription() {
				return "����ں�ǳ�ڿ�ѡ";
			}
	};

	abstract String getDescription();
}

enum PaymentType {
	CASH("��10%�ر��Ż�"),
	CREDIT("�����������ÿ�"),
	LOAN("������ϢΪ.56%");

	final private String payment;

	private PaymentType(String payment) {
		this. payment = payment;
	}
	public String getPayment() {
		return payment;
	}
}


