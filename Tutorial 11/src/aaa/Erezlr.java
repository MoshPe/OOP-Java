package aaa;

import java.util.Scanner;

public class Erezlr {
	private char letter = 'A';
	private safeBoolean stop = new safeBoolean();

	private synchronized void incLetter() {
		if (letter == 'Z')
			letter = 'A';
		else
			letter++;
	}

	private class letterThread implements Runnable {
		@Override
		public void run() {
			System.out.println("Starting with " + letter);
			while (true) {
				try {
					Thread.sleep(250);
					incLetter();
				} catch (InterruptedException e) {
					if (stop.get()) {
						System.out.println("It was the main xD");
						return;
					}
				}
			}
		}
	}

	public void runExample() {
		Runnable r = new letterThread();
		Thread a = new Thread(r);
		a.start();
		Scanner in = new Scanner(System.in);
		in.hasNextLine();
		stop.set(true);
		a.interrupt();
		try {
			a.join();
		} catch (InterruptedException e) {
		}
		System.out.println("Main thread got " + letter);
		System.out.println("both threads done");
		in.close();
	}

	public static void main(String[] args) {
		new Erezlr().runExample();

	}

}
