package ch12;

import static ch12.DiscountType2.*;		//��̬����
import java.util.EnumSet;				//ʹ��EnumSet�ķ���range()

public class EnumTest2 {
   		public static void main( String args[] ) {

	   		for(DiscountType2 type : DiscountType2.values())		//����values()
	   	    	System.out.println("type: " + type.getExplain() + " rate: " + type.getRate());

			//����EnumSet��range()����
			for(DiscountType2 type : EnumSet.range(EXTRA_DISCOUNT, SUPER_DISCOUNT))
				System.out.println("type: " + type.getExplain() + ", rate: " + type.getRate());
		}
}
