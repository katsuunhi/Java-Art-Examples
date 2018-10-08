//Demo: BigDecmial currency and percent formats

import java.text.NumberFormat;
import java.math.BigDecimal;

public class BigDecimalFormatApp {
    public static void main(String[] args) {
    	//Ϊ��ʾ���㣬�����Ѿ��õ������ַ�����ֵ
		String loanAmountString = "129876534219876523.123456789";
		String interestRateString = "0.087654321987654321987654321";

        BigDecimal bigLoanAmount = new BigDecimal(loanAmountString);	//����BigDecimal����
		BigDecimal bigInterestRate = new BigDecimal(interestRateString);
		BigDecimal bigInterest = bigLoanAmount.multiply(bigInterestRate);	//BigDecimal����

		NumberFormat currency = NumberFormat.getCurrencyInstance();	//�������Ҹ�ʽ������
		NumberFormat percent = NumberFormat.getPercentInstance();		//�����ٷֱȸ�ʽ������
		percent.setMaximumFractionDigits(3);							//�ٷֱ�С�������3λ

		//����BigDecimal������Ϊ������format()�е��û��ҺͰٷֱȸ�ʽ��
		System.out.println("Loan amount:\t" + currency.format(bigLoanAmount));
		System.out.println("Interest rate:\t" + percent.format(bigInterestRate));
		System.out.println("Interest:\t" + currency.format(bigInterest));
    }
}