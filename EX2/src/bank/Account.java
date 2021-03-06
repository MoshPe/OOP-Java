package bank;

//this class represent person account 
public class Account {
	private String name;
	private int balance;
	
	public Account(String name) {
		this.name=name;
		balance = 0;
	}
	
	public int getShekels() {
		return balance;
	}
	
	public String getName() {
		return name;
	}
	
	public void add(int amount) {
		balance += amount;
	}
	
	public String toString() {
		return String.format("%s has %d shekels", name, balance);
	}
}
