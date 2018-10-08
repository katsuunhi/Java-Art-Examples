package ch12;

enum DiscountType2 {										//定义枚举类型
	 BASIC_DISCOUNT("for new customers", "10%"),			//枚举常量中有两个子常量
	 EXTRA_DISCOUNT("for returing customers", "20%"),
	 SUPER_DISCOUNT("for royal customers with 3 years", "30%");

	 final private String explain;								//私有实例变量
	 final private String rate;

	 private DiscountType2(String explain, String rate) {			//构造器
		 this.explain = explain;
		 this.rate = rate;
	 }
	 public String getExplain() {								//枚举子常量/访问器
		 return explain;
	 }
	 public String getRate() {
		 return rate;
	 }
}
