package BWinter2020;

public class mainForThreads {
	public static void main(String[] args) throws InterruptedException {
		Stager stager = new Stager();
		class Runner implements Runnable{

			@Override
			public void run() {
				System.out.println("Let");
				try {
					stager.waitUntilStage(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("It");
				try {
					stager.waitUntilStage(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Be");				
			}
			
		}
		new Thread(new Runner()).start();
		new Thread(new Runner()).start();
		Thread.sleep(1000);
		stager.nextStage();
		Thread.sleep(1000);
		stager.nextStage();
	}
}
