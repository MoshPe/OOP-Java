package AWinter2020CheatSheet;

public class Item {
	private String name;

	public Item(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		Item other = (Item) obj;
		return name.equals(other.name);
	}

	public boolean isIn(Item[] many) {
		for (Item item : many) {
			if (equals(item))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Item[] a = { new Item("A"), new Item("B"), new Item("C") };
		System.out.println(new Item("A").isIn(a));
		System.out.println(new Item("X").isIn(a));
	}
}
