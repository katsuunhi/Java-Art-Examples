//利用构造器重载、静态数据和静态方法修改FutureValue类来计算投资回报

import java.text.*;

public class FutureValue {
		private String name;			//用户名
		private int years;				//投资年
		private double  monthlyInvest,		//每月投资额
			 	yearlyRate,		//年投资回报率
			 	futureValue;	//回报值
		private static int count = 0;
		public static final double TAX_RATE = 0.085;
		public static int getCount() {
			return count;
		}

		public static String getFormattedMessage(FutureValue futureValue) {

			//方法链式调用建立货币格式
			String investStr = NumberFormat.getCurrencyInstance().format(futureValue.getMonthlyInvest());
			String futureValueStr = NumberFormat.getCurrencyInstance().format(futureValue.getFutureValue());
			
			//百分比格式化，至少保留小数点两位
			NumberFormat percent = NumberFormat.getPercentInstance();
			percent.setMinimumFractionDigits(2);
			String rateStr = percent.format(futureValue.getYealyRate()/100);

			String message =  futureValue.getName() + "\n"
							+ investStr + "\n"
							+ rateStr + "\n"
							+ futureValue.getYears() + "\n"
							+ futureValueStr + "\n\n";

			return message;
		}

		public FutureValue () {
			name = "无名氏";
			monthlyInvest = 0.0;
			yearlyRate = 0.0;
			years = 0;
			futureValue = 0.0;
			count++;			//increase user count by 1
		}
		public FutureValue(String name) {
			this.name = name;
			monthlyInvest = 0.0;
			yearlyRate = 0.0;
			years = 0;
			futureValue = 0.0;
			count++;
		}
		public FutureValue(String name, double monthlyInvest){
			this.name = name;
			this.monthlyInvest = monthlyInvest;
			yearlyRate = 6.5;	//程序预设值
			years = 1;			//程序预设至少1年
			futureValue = 0.0;
			count++;
		}
		public FutureValue(String name, double monthlyInvest, double yearlyRate) {
			this.name = name;
			this.monthlyInvest = monthlyInvest;
			this.yearlyRate = yearlyRate;
			years = 1;
			futureValue = 0.0;
			count++;
		}
		public FutureValue(String name, double monthlyInvest, double yearlyRate, int years) {
			this.name = name;
			this.monthlyInvest = monthlyInvest;
			this.yearlyRate = yearlyRate;
			this.years = years;
			futureValue = 0.0;
			count++;
		}
		//following are setXx() and getXxx() for class variables
		public void setName(String userName) {
					name = userName;
				}
		public String getName() {
					return name;
				}

		public void setMonthlyInvest(double monthlyInvestment) {
					monthlyInvest = monthlyInvestment;
				}
		public double getMonthlyInvest() {
					return monthlyInvest;
				}
		public void setYearlyRate(double yearlyReturnRate) {
					yearlyRate = yearlyReturnRate;
				}
		public double getYealyRate() {
					return yearlyRate;
				}
		public void setYears(int investYears){
					years = investYears;
				}
		public int getYears() {
					return years;
				}
		public double getFutureValue() {
					return futureValue;
				}
		public void futureValueCompute() {  //计算投资回报率的方法
					double monthlyReturnRate = yearlyRate/12/100;
					int months = years * 12;	//转换成月
					int i = 1;					//应用do-while循环
					do  {
						futureValue = (futureValue + monthlyInvest) *
									  (1 + monthlyReturnRate);
						i++;
			 		}	while (i <= months);		//do-while 结束
		}		   				//方法futureValueCompute结束
		public double getTaxCompute() {
			return futureValue * FutureValue.TAX_RATE;
		}
	}	//类FutureValue结束
