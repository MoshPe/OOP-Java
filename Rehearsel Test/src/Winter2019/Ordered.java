package Winter2019;

public class Ordered {
	private int now = 0;
	private Object lock = new Object();
	private Object print = new Object();

	private class Player implements Runnable {
		private int order;

		public Player(int order) {
			this.order = order;
		}

		@Override
		public void run() {
			synchronized (lock) {
				while (order > now) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
					}
				}
				System.out.println(order + " is printing!");
				now++;
				lock.notifyAll();
			}
		}
	}

	public void runOrdered() {
		now = 0;
		for (int i = 0; i < 3; i++) {
			Thread t = new Thread(new Player(i));
			t.start();
		}
	}

	public static void main(String[] args) {
		Ordered o = new Ordered();
		o.runOrdered();
	}

}
