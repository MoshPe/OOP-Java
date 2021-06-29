package Winter2019;

public class Road extends Edge{
	private int length;

	public Road(City fromCity, City toCity, int length) {
		super(fromCity, toCity);
		this.length = length;
	}
	
	public int getLength() {
		return length;
	}

}
