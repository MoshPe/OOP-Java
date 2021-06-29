package EX6_Threads_Q3;

public class RunCallable <U,V>{
	private Thread thread;
	private U result = null;
	private Object lock = new Object();
	
	// A way to create a thread that get a value instead of using the normal run
	// which doesn't get anything
	public void start(Callable<U,V> c, V val) {
		thread = new Thread(new Runnable() {
			@Override
			public void run() {
				U res = c.call(val);
				synchronized (lock) {
					result = res;
					lock.notifyAll();
				}
			}
		});
		thread.start();
	}
	
	public U waitForResult() {	
		synchronized (lock) {
			while(result == null)
				try {
					lock.wait();
				} catch (InterruptedException e) {
				}
		}
		return result;
	}
	
	public U getResult() {
		return result;
	}

}
