package fghfgh;

public class MostCommonReporter implements Reporter{
	private int arr[];
	private int index = 0;
	
	public MostCommonReporter(int upperBound) {
		arr = new int[upperBound];
	}
	
	@Override
	public void addNumber(int num) {
		arr[num]++;	
		if(arr[num] > arr[index])
			index = num;
	}

	@Override
	public int report() {
		return index;
	}
	
	public String toString(){
		return "Most Common";
	}

}
