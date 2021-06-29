package Threads;

public class SafeArray {
	private int[] counter;
	private Object[] guards;
	
	public SafeArray(int size) {
		counter = new int[size];
		guards = new Object[size];
		for (int i = 0; i < guards.length; i++) {
			guards[i] = new Object();
		}
	}
	
	public void increase(int index, int amount) {
		synchronized (guards[index]) {
			counter[index] += amount;
		}
	}
	
	public int get(int index) {
		synchronized (guards[index]) {
			return counter[index];
		}
	}

}
