package EX6_Threads_Q2;

public class Q2_main {
	private Exchange<String> check = new Exchange<>();
	
	private class Runner1 implements Runnable{
		
		@Override
		public void run() {
			System.out.println("Runner1");
			System.out.println("Runner1 " + check.give1("hi1"));
		}
		
	}
	
	private class Runner2 implements Runnable{
		
		@Override
		public void run() {
			System.out.println("Runner2");
			System.out.println("Runner2 " + check.give2("hi2"));
		}
		
	}
	
	public void runExample() {
		new Thread(new Runner1()).start();
		new Thread(new Runner2()).start();
	}
	
	public static void main(String[] args) {
		new Q2_main().runExample();
	}

}
