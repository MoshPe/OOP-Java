package BWinter2020;

public class Stager {
	private int stage = 0;
	
	
	public synchronized void nextStage() {
		stage++;
		notifyAll();
	}
	
	public synchronized void waitUntilStage(int i) throws InterruptedException{
		while(i > stage)
				wait();
	}
}
