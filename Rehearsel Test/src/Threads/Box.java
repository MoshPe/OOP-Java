package Threads;

import java.util.ArrayList;
import java.util.List;

public class Box<T>{
	private T value;
	//private List<Thread> takers = new ArrayList<>();
	private List<Thread> puters = new ArrayList<>();
	private boolean isEmpty = true;
	
	public synchronized void put(T value) {
		while(!isEmpty)
			justWait();
		puters.add(Thread.currentThread());
		this.value = value;
		isEmpty = false;
		notifyAll();
	}
	
	public synchronized T getValue() {
		T temp = value;
		while(isEmpty)
			justWait();
		isEmpty = true;
		value = null;
		notifyAll();
		return temp;
	}

	public void justWait() {
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}
}
