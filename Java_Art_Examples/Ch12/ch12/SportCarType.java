package ch12;

enum SportCarType {
	 PORSCHE("制造国：德国", 120000),
	 FERRARI("制造国: 意大利 ", 150000),
	 JAGUAR("制造国：英国", 110000);

	 final private String make;
	 final private int price;

	 private SportCarType(String make, int price) {
		 this.make = make;
		 this.price = price;
	 }
	 public String getMake() {
		 return make;
	 }
	 public int getPrice() {
		 return price;
	 }
}

