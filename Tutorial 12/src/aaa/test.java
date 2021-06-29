package aaa;
import java.util.Random;
public class test {

		ReadWriteLock lock = new ReadWriteLock();
		Random rand = new Random();
		private int commonVal;

		private void randSleep(int maxMillis) {
			synchronized (rand) { // Why? because Random objects are not thread safe.
				try {
					Thread.sleep(rand.nextInt(maxMillis));
				} catch (InterruptedException e) {
				}
			}
		}

		private void printMsg(String msg) {
			System.out.println(Thread.currentThread().getName() + msg);
		}

		private class Writer implements Runnable {
			public void run() {
				while (true) {
					randSleep(1000);
					lock.getWriteLock();
					printMsg(" Writing");
					commonVal++;
					randSleep(1000);
					printMsg(" Done writing");
					lock.unlock();
				}
			}
		}

		private class Reader implements Runnable {
			public void run() {
				while (true) {
					randSleep(1000);
					lock.getReadLock();
					printMsg(" Reading " + commonVal);
					randSleep(100);
					printMsg(" Done reading");
					lock.unlock();
				}
			}
		}

		public void runExample() {
			new Thread(new Reader()).start();
			new Thread(new Reader()).start();
			new Thread(new Writer()).start();
			new Thread(new Writer()).start();
		}

		public static void main(String[] args) {
			new test().runExample();
		}
	}

