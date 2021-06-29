package BSpring2020;

public class Counter {
	private int counter = 0;
	private Thread mainThread = null;
	private boolean flag = true;
	
	public Runnable stepper(int i) {
		return new runner(i);
	}
	
	private class runner implements Runnable{
		private int i;
		private int timesOfRunning = 0;
		
		public runner(int i) {
			this.i = i;
		}
		
		@Override
		public void run() {
			if(timesOfRunning %2 == 0) {
				inc(i);
				mainThread = Thread.currentThread();
			}
			timesOfRunning++;
		}
		
		private synchronized void inc(int i) {
			counter += i;
		}		
	}
	@Override
	public String toString() {
		return "(" + counter + ")";
	}
	
	public static void main(String[] args) {
		Counter c = new Counter();
		Runnable s3 = c.stepper(3);
		Runnable s2 = c.stepper(2);
		s2.run();
		System.out.println(c);
		s2.run();
		System.out.println(c);		
		s2.run();
		System.out.println(c);
		s3.run();
		System.out.println(c);
		s2.run();
		System.out.println(c);
		s3.run();
		System.out.println(c);
		s3.run();
		System.out.println(c);
	}

}
