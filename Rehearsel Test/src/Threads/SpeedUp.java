package Threads;

public class SpeedUp {
	private final int start = 2;
	private int count = 0;
	private int upperBound;
	
	
	private synchronized void inc(int amount) {
		count += amount;
	}
	private class PrimeCounter implements Runnable{
		private int from, to;
			
		public PrimeCounter(int from, int to) {
			this.from = from;
			this.to = to;
		}
		
		@Override
		public void run() {
			int counter = 0;
			for (int i = from; i < to; i++) {
				if(checkPrime(i))
					counter++;
			}
			inc(counter);
		}
		
		private boolean checkPrime(int n) {
			if (n == 2 || n == 3)
		        return true;
		    if (n <= 1 || n % 2 == 0 || n % 3 == 0)
		        return false;
		    for (int i = 5; i * i <= n; i += 6)
		    {
		        if (n % i == 0 || n % (i + 2) == 0)
		            return false;
		    }
		    return true;
		}
	}
	
	public void runExample() {
		
	}
	
	
	
	
	
	
	
	
	
}
