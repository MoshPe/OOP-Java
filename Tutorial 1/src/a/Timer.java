package a;

public class Timer {
	private int m,s;
	
	public Timer(int m, int s) {
		this.m = m;
		this.s = s;
	}
	
	public Timer(int s) {
		this.m = s / 60;
		this.s = s % 60;
	}
	
	public boolean tickDown() {
		if(m == 0 & s == 0)
			return false;
		if(s == 0) {
			m--;
			s=59;
		}
		else
			s--;
		return true;
	}
	
	public Timer diff(Timer other) {
		if(other.totalSeconds() > totalSeconds())
			return null;
		return new Timer(totalSeconds() - other.totalSeconds());
	}
	
	public String toString() { return "(" + m + ":" + ((s>9)?s : "0" + s) + ")"; }
		
	public int totalSeconds() { return s + m * 60; }

}