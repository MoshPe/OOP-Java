package Tree;

public abstract class Tree {
	private int buyingCost;

	public Tree(int buyingCost) {
		this.buyingCost = buyingCost;
	}

	public abstract String getName();

	protected abstract int costAtYear(int year);

	public int totalCost(int year) {
		int sum = buyingCost;
		for (int i = 0; i < year; i++)
			sum += costAtYear(i);
		return sum;
	}
}
