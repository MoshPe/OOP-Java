package Tuturial11;

import java.util.Scanner;

public class ErezIr {
	private char letter = 'A';
	private Object lock = new Object();
	private boolean isMain = false;
	
	private synchronized void setIsMain() {
		isMain = true;
	}
	
	private class ErezIrThread implements Runnable {

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(250);
					synchronized (lock) {
						if (letter == 'Z')
							letter = 'A';
						else
							letter++;
					}
				} catch (InterruptedException e) {
				}
				synchronized (lock) {
					if(isMain == true) {
						System.out.println("Heyo, its the main :D");
						return;
					}
				}

			}

		}
	}

	public void runExample() {
		Thread t = new Thread(new ErezIrThread());
		t.start();
		Scanner in = new Scanner(System.in);
		in.hasNextLine();
		t.interrupt();
		setIsMain();
		try {
			t.join();
		} catch (InterruptedException e) {
		}
		System.out.println("The letter is " + letter);
		in.close();
	}
	
	public static void main(String[] args) {
		new ErezIr().runExample();
	}
}
