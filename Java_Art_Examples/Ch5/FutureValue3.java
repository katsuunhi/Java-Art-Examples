//����do-whileѭ���޸�FutureValue��������Ͷ�ʻر���

public class FutureValue3 {
		private String name;			//�û���
		private int years;				//Ͷ����
		private double  monthlyInvest,		//ÿ��Ͷ�ʶ�
			 	yearlyRate,		//��Ͷ�ʻر���
			 	futureValue;	//�ر�ֵ
		
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
	}	//��FutureValue3����
