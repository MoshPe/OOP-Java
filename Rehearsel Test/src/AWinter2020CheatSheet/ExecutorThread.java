package AWinter2020CheatSheet;

import java.util.Deque;
import java.util.LinkedList;

public class ExecutorThread implements Runnable{
	private Object lock = new Object();
	private Deque<Runnable> queue = new LinkedList<>();
	
	@Override
	public void run() {
		while(true) {
			poll();
		}
	}
	
	private synchronized void poll() {
		while(queue.isEmpty())
			justWait();
		queue.poll().run();
	}
	
	public synchronized void add(Runnable r) {
		queue.add(r);
		if(!queue.isEmpty())
			notify();
	}
	
	private void justWait() {
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}
}
