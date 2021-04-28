package iterator;

public class Fibonacci  implements MyIterator {
	private int upperBound;
	private int fibOne,fibTwo;
	public Fibonacci(int upperBound) {
		this.upperBound = upperBound;
		fibOne = 0;
		fibTwo = 1;
	}
	@Override
	public boolean hasNext() { return fibTwo <= upperBound; }

	@Override
	public int next() {
		if(!hasNext())
			throw new IndexOutOfBoundsException();
		fibTwo += fibOne;
		fibOne = fibTwo - fibOne;    
		return fibOne;
	}
	
	public static void main(String[] argc) {
	MyIterator it = new Fibonacci(13);
		while(it.hasNext()) 
			System.out.print(it.next() + " ");
	}
}
