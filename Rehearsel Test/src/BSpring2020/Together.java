package BSpring2020;

import java.util.ArrayList;
import java.util.List;

public class Together {
	private List<Runnable> runs = new ArrayList<>();
	private boolean isRunning = false;
	
	public synchronized void add(Runnable r) {
		runs.add(r);
	}
	
	public synchronized void runAll() {
		if(runs.isEmpty())
			return;
		isRunning = true;
		Thread[] temp = new Thread[runs.size()];
		for (int i = 0; i < temp.length; i++)
			temp[i] = new Thread(runs.get(i));
		
		for (Thread thread : temp)
			thread.start();
		for (Thread thread : temp) {
			try {
				thread.join();
			} catch (InterruptedException e) {
			}
		}
		runs.clear();
	}
		
	public static void main(String[] args) {
		Together t = new Together();
		Runnable r = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					System.out.print(i);
				}
			}
		};
		t.add(r);
		t.add(r);
		t.runAll();
		System.out.print(" X ");
		t.add(r);
		t.runAll();
		System.out.print(" Y");
	}
}
