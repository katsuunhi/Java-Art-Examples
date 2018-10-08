package ch12;

import static ch12.DiscountType2.*;		//静态引入
import java.util.EnumSet;				//使用EnumSet的方法range()

public class EnumTest2 {
   		public static void main( String args[] ) {

	   		for(DiscountType2 type : DiscountType2.values())		//调用values()
	   	    	System.out.println("type: " + type.getExplain() + " rate: " + type.getRate());

			//调用EnumSet的range()方法
			for(DiscountType2 type : EnumSet.range(EXTRA_DISCOUNT, SUPER_DISCOUNT))
				System.out.println("type: " + type.getExplain() + ", rate: " + type.getRate());
		}
}
