//�� Payment������������������

import javax.swing.JOptionPane;

public class PaymentApp {
	public static void main(String[] args) {

		Payment payment = new Payment(); //������Payment�Ķ���

		String str;		//����һ���ַ���

		str = JOptionPane.showInputDialog("�����뵥��: "); //�õ�����

		payment.setPrice(Double.parseDouble(str)); //ת����˫������ֵ

		str = JOptionPane.showInputDialog("����������: "); //�õ�����

		payment.setQuantity(Integer.parseInt(str));  //ת�������������÷���

		payment.bill();	//���ü��㷽��

		//��ʾ���
		JOptionPane.showMessageDialog(null, "�ܽ���� " + payment.getTotal());
	} //main()��������
} //������PaymentApp����

