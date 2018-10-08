package ch12;

enum DiscountType2 {										//����ö������
	 BASIC_DISCOUNT("for new customers", "10%"),			//ö�ٳ������������ӳ���
	 EXTRA_DISCOUNT("for returing customers", "20%"),
	 SUPER_DISCOUNT("for royal customers with 3 years", "30%");

	 final private String explain;								//˽��ʵ������
	 final private String rate;

	 private DiscountType2(String explain, String rate) {			//������
		 this.explain = explain;
		 this.rate = rate;
	 }
	 public String getExplain() {								//ö���ӳ���/������
		 return explain;
	 }
	 public String getRate() {
		 return rate;
	 }
}
