package aaa;

public class safeBoolean {
	private boolean value;
	
	public synchronized boolean get() {
		return value;
	}
	
	public synchronized void set(boolean value) {
		this.value = value;
	}
}
