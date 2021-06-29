package ASpring2020;

public class Flag {
	private int range;
	private int val;
	
	public Flag(int range) {
		this.range = range ;
	}
	
	public synchronized void set(int val) {
		checkValidation(val);
		this.val = val;
		notifyAll();
	}
	
	public synchronized void waitFor(int val) {
		checkValidation(val); 
		while(this.val != val)
			justWait();
	}
	
	private void checkValidation(int val) {
		if(val < 0 || val >= range)
			throw new IllegalArgumentException();	
	}
	
	
	
	private void justWait() {
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}
}
