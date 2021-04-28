package rooms;

public class Bathroom extends Room {
	private int height;
	
	public Bathroom(int width, int length,int height, int costPerMeter) {
		super(length,width,costPerMeter);
		this.height = height;
	}
	
	@Override
	public int cost() {
		return 2 * (length + width) * height * costPerMeter + super.cost();
	}
	
	public static void main(String[] args) {
		Bathroom b = new Bathroom(1,2,3,4);
		Room r = new Room(4,5,2);
		System.out.println(r);
		System.out.println(b);
	}
}
