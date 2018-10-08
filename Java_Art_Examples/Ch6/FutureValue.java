//���ù��������ء���̬���ݺ;�̬�����޸�FutureValue��������Ͷ�ʻر�

import java.text.*;

public class FutureValue {
		private String name;			//�û���
		private int years;				//Ͷ����
		private double  monthlyInvest,		//ÿ��Ͷ�ʶ�
			 	yearlyRate,		//��Ͷ�ʻر���
			 	futureValue;	//�ر�ֵ
		private static int count = 0;
		public static final double TAX_RATE = 0.085;
		public static int getCount() {
			return count;
		}

		public static String getFormattedMessage(FutureValue futureValue) {

			//������ʽ���ý������Ҹ�ʽ
			String investStr = NumberFormat.getCurrencyInstance().format(futureValue.getMonthlyInvest());
			String futureValueStr = NumberFormat.getCurrencyInstance().format(futureValue.getFutureValue());
			
			//�ٷֱȸ�ʽ�������ٱ���С������λ
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
			name = "������";
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
			yearlyRate = 6.5;	//����Ԥ��ֵ
			years = 1;			//����Ԥ������1��
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
		public void futureValueCompute() {  //����Ͷ�ʻر��ʵķ���
					double monthlyReturnRate = yearlyRate/12/100;
					int months = years * 12;	//ת������
					int i = 1;					//Ӧ��do-whileѭ��
					do  {
						futureValue = (futureValue + monthlyInvest) *
									  (1 + monthlyReturnRate);
						i++;
			 		}	while (i <= months);		//do-while ����
		}		   				//����futureValueCompute����
		public double getTaxCompute() {
			return futureValue * FutureValue.TAX_RATE;
		}
	}	//��FutureValue����
