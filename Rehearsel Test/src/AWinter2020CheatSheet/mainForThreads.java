package AWinter2020CheatSheet;

public class mainForThreads {
	public static void main(String[] args) {
		ExecutorThread e = new ExecutorThread();
		new Thread(e).start();
		class Runner implements Runnable{

			@Override
			public void run() {
				for (int i = 0; i < 10; i++)
					System.out.print(i);
				System.out.println();
			}
		}
		e.add(new Runner());
		e.add(new Runner());
		System.out.println("After");
	}
}
