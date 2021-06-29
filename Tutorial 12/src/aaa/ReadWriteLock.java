package aaa;

import java.util.HashSet;
import java.util.Set;

public class ReadWriteLock {
	Set<Thread> readers = new HashSet<>();
	private Thread myLock = null;

	public synchronized void getReadLock() {
		while(myLock != null) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		readers.add(Thread.currentThread());
	}

	public synchronized void getWriteLock() {
		while (!readers.isEmpty() || myLock != null) {
			try {
				wait();
			} catch (Exception e) {}
		}
		myLock = Thread.currentThread();
	}

	public synchronized void unlock() {
		if (Thread.currentThread() == myLock) {
			myLock = null;
			notifyAll();
		} else if (readers.contains(Thread.currentThread())) {
			readers.remove(Thread.currentThread());
			if (readers.isEmpty())
				notifyAll();
		} else
			throw new RuntimeException("There isnt a thread like it");
	}
}
