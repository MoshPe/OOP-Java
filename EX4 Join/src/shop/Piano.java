package shop;

//this class represent Piano (subclass of instrument)

public class Piano extends Instrument{
	private int octaves;

	public Piano(String company, int price, int octaves) {
		super(company,price);
		this.octaves = octaves;
	}

	public int getOctaves() {
		return octaves;
	}
	
	@Override
	public String toString() {
		return String.format("Piano(%d octaves) %s(%d), price = %d", octaves, getCompany(),getSerial(), getPrice());
	}


}
