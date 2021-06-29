package Threads;

public class SimpleThreads {

	static void threadMessage(String msg) {
		System.out.format("%s: %s%n", Thread.currentThread().getName(), msg);
	}

	private static class MsgLoop implements Runnable {

		@Override
		public void run() {
			String[] lines = { "One", "Two", "Three" };
			try {
				for (String string : lines) {
					Thread.sleep(1000);
					threadMessage(string);
				}
			}catch(InterruptedException e) {
				threadMessage("I wasn'd done");
			}
		}

	}
	
	public static void main(String[] args) throws InterruptedException {
		threadMessage("Starting MsgLoop thread");
		long startTime = System.currentTimeMillis();
		Thread t = new Thread(new MsgLoop());
		t.start();
		threadMessage("Waiting.");
		while(t.isAlive()) {
			threadMessage("Still waiting!");
			t.join(600);
			long now = System.currentTimeMillis();
			if(now - startTime > 2000 && t.isAlive()) {
				threadMessage("Tired of waiting.");
				t.interrupt();
				t.join();
			}
		}
		threadMessage("Finally xD");
	}
}
