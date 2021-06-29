package Tutorial12;

import java.util.ArrayList;
import java.util.List;

public class ReadWriteLock {
	private Thread write = null;
	private List<Thread> reads = new ArrayList<Thread>();

	public void justWait() {
		try {
			wait();
		} catch (InterruptedException e) {
		}		
	}
	
	public synchronized void getReadLock() {
		while(write != null)
			justWait();
		reads.add(Thread.currentThread());
	}
	
	public synchronized void getWriteLock() {
		while(write != null || !reads.isEmpty())
			justWait();
		write = Thread.currentThread();
	}
	
	public synchronized void unlock() {
		if(write == Thread.currentThread()) {
			write = null;
			notify();
		}
		else {
			reads.remove(Thread.currentThread());
			if(reads.isEmpty())
				notify();
		}

	}

}
