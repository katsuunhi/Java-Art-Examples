//测试不同百分比格式化程序

import java.util.*;
import java.text.*;

public class TestPercentApp {
	public static void main(String[] args) {
		//系统预设的百分比格式
		NumberFormat percent = NumberFormat.getPercentInstance();
		String rate = percent.format(0.0756);
		System.out.println("系统预设格式-rate: " + rate);
		
		rate = percent.format(0.0651);
		System.out.println("系统预设格式 percent of 0.0651: " + rate);
		
		rate = percent.format(0.0650);
		System.out.println("系统预设格式 percent of 0.0650: " + rate);
		
		//或者使用链式方法调用
		double interest = 0.065;
		rate = NumberFormat.getPercentInstance().format(interest);
		System.out.println("链式方法调用-rate: " + rate);
		
		rate = NumberFormat.getPercentInstance().format(0.065001);
		System.out.println("rate3: " + rate);
		rate = NumberFormat.getPercentInstance().format(0.075);
		System.out.println("rate4: " + rate);
		
		NumberFormat percent2 = NumberFormat.getPercentInstance();
		percent2.setMinimumFractionDigits(4);		//至少保留4位小数
		String rate3 = percent2.format(.0650);
		String rate4 = percent2.format(0.075);
		System.out.println("rate3 = " + rate3 + "\trate4 = " + rate4);
		
		//意大利百分比格式
		NumberFormat percent3 = NumberFormat.getPercentInstance(Locale.ITALY);
		percent3.setMaximumFractionDigits(4);		//至少保留4位小数
		String rate2 = percent3.format(0.07551008);
		System.out.println("意大利百分比格式: " + rate2);	
	}
}
