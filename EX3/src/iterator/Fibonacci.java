package iterator;

//this function return the next number in the Fibonacci sequence till we reach the upperbound
public class Fibonacci implements MyIterator {
	private int last, next, upperBound;

	public Fibonacci(int upperBound) {
		this.upperBound = upperBound;
		last = 0;
		next = 1;
	}

	@Override
	public boolean hasNext() { // if the next number isn't above the upperbound return true
		return next < upperBound;
	}

	@Override
	public int next() {
		if (hasNext()) { // if we didn't reach the upper bound
			int temp = last;
			last = next; // get the current fibo number
			next += temp; // calculate the next fibo number
		}
		return last;
	}

}
