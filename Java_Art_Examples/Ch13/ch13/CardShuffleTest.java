package ch13;

import java.util.*;
public class CardShuffleTest {
		public static void main(String[] args) {

			String[] cardArray = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
			List<String> cardList = Arrays.asList(cardArray);		//将cardArray的元素复制到集合

			Collections.shuffle(cardList);							//调用洗牌方法

			System.out.println("cardlist = " + cardList);			//打印结果

			Collections.shuffle(cardList, new Random(10));			//调用洗牌方法
			System.out.println("cardlist = " + cardList);			//打印结果
  		}
}
