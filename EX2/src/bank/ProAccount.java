package bank;

//this class represent person account with history feature, subclass of account class
public class ProAccount extends Account {

	private int[] history;
	private int currentHistory;

	public ProAccount(String name) { // constructor
		super(name);
		history = new int[100];
		currentHistory = 0;
	}

	@Override
	public void add(int amount) {
		super.add(amount);
		history[currentHistory++] = getShekels();
	}

	@Override
	public String toString() {
		return super.toString() + " " + ArrToString();
	}

	public static void transfer(ProAccount from, ProAccount to, int amount) {
		from.add(-amount);
		to.add(amount);
	}

	private String ArrToString() {
		String returnArrToString = "[";
		for (int i = 0; i < currentHistory; i++)
			returnArrToString += history[i] + (i == currentHistory - 1 ? "" : ",");
		return returnArrToString + "]";
	}
}
