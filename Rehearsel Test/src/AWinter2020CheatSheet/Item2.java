package AWinter2020CheatSheet;

public class Item2 extends Item{
	private int price;
	
	public Item2(String name, int price) {
		super(name);
		this.price = price;
	}
	
	@Override
	public boolean equals(Object obj) {
		Item2 other = (Item2) obj;
		return price == other.price ? super.equals(obj) : false; 
	}
	
	public static void main(String[] args) {
		Item2[] a = { new Item2("A", 1), new Item2("B", 2), new Item2("C", 3) };
		System.out.println(new Item2("B", 2).isIn(a));
		System.out.println(new Item2("C", 10).isIn(a));
		System.out.println(new Item2("D", 1).isIn(a));
	}
}
