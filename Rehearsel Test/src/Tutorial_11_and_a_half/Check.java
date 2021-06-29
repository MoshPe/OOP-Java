package Tutorial_11_and_a_half;

public class Check {
	private boolean[] a;
	private Thread mainThread;
	
	public Check(boolean[] a) {
		this.a = a;
	}
	
	private class Searcher implements Runnable{
		private int from, to;
		
		public Searcher(int from, int to) {
			this.from = from;
			this.to = to;
		}
		
		@Override
		public void run() {
			for (int i = from; i < to; i++) {
				if(a[i])
					mainThread.interrupt();
				else if(Thread.interrupted())
					return;	
			}  	
			//System.out.format("%s from %d to %d\n",Thread.currentThread().getName(),from,to);
		}
	}
	
	public void check(int n) {
		Thread[] threads = new Thread[n];
		mainThread = Thread.currentThread();
		int start = 0, workPerThread = a.length / n;
		int to = workPerThread - 1;
		for (int i = 0; i < threads.length; i++) {
			threads[i]  = new Thread(new Searcher(start, to));
			start += workPerThread;
			to += workPerThread + 1;
			threads[i].start();	
		}
		try {
			for (Thread thread : threads)
					thread.join();
		} catch (InterruptedException e) {
			for (Thread t : threads)
				t.interrupt();
			System.out.println("found it!");
			return;
		}
		if(Thread.interrupted())
			System.out.println("Found it!");
		else
			System.out.println("Nope, not there");
	}
	
	public static void main(String[] args) {
		boolean[] a = new boolean[10000110];
		a[a.length - 1] = true;
		a[1] = true;
		long time = System.currentTimeMillis();
		new Check(a).check(2);
		System.out.println(System.currentTimeMillis() - time);
	}
}
