package ch13;

import java.util.*;
public class CardShuffleTest {
		public static void main(String[] args) {

			String[] cardArray = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
			List<String> cardList = Arrays.asList(cardArray);		//��cardArray��Ԫ�ظ��Ƶ�����

			Collections.shuffle(cardList);							//����ϴ�Ʒ���

			System.out.println("cardlist = " + cardList);			//��ӡ���

			Collections.shuffle(cardList, new Random(10));			//����ϴ�Ʒ���
			System.out.println("cardlist = " + cardList);			//��ӡ���
  		}
}
