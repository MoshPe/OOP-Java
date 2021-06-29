package Threads;

public class TwoThreads implements Runnable{
	private int i;
	
	@Override
	public void run() {
		while(i < 6) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			System.out.println(i++ + " printed by " + Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		Runnable r = new TwoThreads();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
	}
}
