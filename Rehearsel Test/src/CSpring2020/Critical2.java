package CSpring2020;

import java.util.Random;

public class Critical2 {
	private int count = 0;
	private static Random rand = new Random();

	public void runIt(Runnable r) {
		checkRunningThreads();
		r.run();
		exitRunning();
	}

	private synchronized void exitRunning() {
		count--;
		notify();
	}

	private synchronized void checkRunningThreads() {
		while (count == 2)
			justWait();
		count++;
	}

	public void justWait() {
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}
	

	public static void randSleep() {
		try {
			Thread.sleep(rand.nextInt(100));
		} catch (InterruptedException e) {
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Critical2 c2 = new Critical2();
		for (int i = 0; i < 20; i++)
			new Thread(new Runnable() {
				public void run() {
					c2.runIt(new Runnable() {
						public void run() {
							randSleep();
							System.out.print("[");
							randSleep();
							System.out.print("]");
						}
					});
				}
			}).start();
	}
}
