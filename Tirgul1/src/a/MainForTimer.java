package a;

public class MainForTimer {

	public static void main(String[] args) {
		Timer time = new Timer(2,35);
		System.out.println("The time is " + time);
		Timer time1 = new Timer(4,20);		
		System.out.println("The total seconds are: " + time.totalSeconds());
		//time.tickDown();
		System.out.println("The time is " + time);
		Timer time2 =  time1.diff(time);		
		System.out.println("The time is " + time2);
		
		
	}
}