//利用do-while循环修改FutureValue类来计算投资回报率

public class FutureValue3 {
		private String name;			//用户名
		private int years;				//投资年
		private double  monthlyInvest,		//每月投资额
			 	yearlyRate,		//年投资回报率
			 	futureValue;	//回报值
		
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
	}	//类FutureValue3结束
