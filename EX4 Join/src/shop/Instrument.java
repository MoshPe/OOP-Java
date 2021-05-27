package shop;

//abstract class that represent instruments

public abstract class Instrument {
	public static int serialNumber = 0;
	private String company;
	private int price, serialNum;

	public Instrument(String company, int price) {
		this.company = company;
		this.price = price;
		serialNum = serialNumber++;
	}

	public int getPrice() {
		return price;
	}

	public String getCompany() {
		return company;
	}

	public int getSerial() {
		return serialNum;
	}
}
