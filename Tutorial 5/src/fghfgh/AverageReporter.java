package fghfgh;

public class AverageReporter implements Reporter{
	private int sum = 0;
	private int count = 0;
	
	@Override
	public void addNumber(int num) {
		sum += num;
		count++;
	}

	@Override
	public int report() {
		return sum / count;
	}
	
	public String toString(){
		return "Average";
	}
	

}
