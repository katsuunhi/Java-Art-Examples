//Demo: BigDecmial currency and percent formats

import java.text.NumberFormat;
import java.math.BigDecimal;

public class BigDecimalFormatApp {
    public static void main(String[] args) {
    	//为演示方便，假设已经得到如下字符串数值
		String loanAmountString = "129876534219876523.123456789";
		String interestRateString = "0.087654321987654321987654321";

        BigDecimal bigLoanAmount = new BigDecimal(loanAmountString);	//创建BigDecimal对象
		BigDecimal bigInterestRate = new BigDecimal(interestRateString);
		BigDecimal bigInterest = bigLoanAmount.multiply(bigInterestRate);	//BigDecimal运算

		NumberFormat currency = NumberFormat.getCurrencyInstance();	//建立货币格式化引用
		NumberFormat percent = NumberFormat.getPercentInstance();		//建立百分比格式化引用
		percent.setMaximumFractionDigits(3);							//百分比小数点最多3位

		//利用BigDecimal对象作为参数在format()中调用货币和百分比格式化
		System.out.println("Loan amount:\t" + currency.format(bigLoanAmount));
		System.out.println("Interest rate:\t" + percent.format(bigInterestRate));
		System.out.println("Interest:\t" + currency.format(bigInterest));
    }
}