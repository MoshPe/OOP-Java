package EX6_Threads;

import Tutorial_11_and_a_half.Check;

public class Cascade {
	private Thread[] threads;
	private Object[] locks;
	private String start = null;

	private class Cycle implements Runnable {
		private int place;
		private String name;

		public Cycle(String name, int place) {
			this.name = name;
			this.place = place;
		}

		@Override
		public void run() {
			while (true) {
				synchronized (locks[place]) {
						try {
							locks[place].wait();
						} catch (InterruptedException e) {
						}
					}
					System.out.println(name);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					locks[place == threads.length - 1? 0 : place + 1].notify();
			}
		}

	}

	public void runExample(int n) {
		threads = new Thread[n];
		locks = new Object[n];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Cycle("hi"+i,i));
			locks[i] = new Object();
			threads[i].start();
		}
		locks[0].notify();
	}
	
	public static void main(String[] args) {
		new Cascade().runExample(5);
	}
}
