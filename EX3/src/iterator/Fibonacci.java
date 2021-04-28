package iterator;

public class Fibonacci implements MyIterator {
	private int upperBound;
	private int fibOne, fibTwo;

	public Fibonacci(int upperBound) {
		this.upperBound = upperBound;
		fibOne = 0;
		fibTwo = 1;
	}

	@Override
	public boolean hasNext() {
		return fibTwo < upperBound;
	}

	@Override
	public int next() {
			if (!hasNext())
				return fibOne;
			fibTwo += fibOne;
			fibOne = fibTwo - fibOne;
			return fibOne;
	}
}
