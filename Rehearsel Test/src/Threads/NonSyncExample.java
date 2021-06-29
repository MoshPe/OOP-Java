package Threads;

public class NonSyncExample {
	private int c = 0;
	private Object lock = new Object();

	public static void main(String[] args) {
		NonSyncExample se = new NonSyncExample();
		se.runExample();
	}
	
	private synchronized void inc() {
		c++;
	}

	private class Counter implements Runnable {
		
		@Override
		public void run() {
			for (int i = 0; i < 1000; i++)
				inc();
		}
	}

	public void runExample() {
		for (int i = 0; i < 10; i++) {
			Thread t1 = new Thread(new Counter());
			Thread t2 = new Thread(new Counter());
			t1.start();
			t2.start();
			try {
				t1.join();
				t2.join();
			} catch (InterruptedException e) {
			}
			System.out.println(c);
			c = 0;
		}

	}

}
