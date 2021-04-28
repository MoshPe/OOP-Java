package iterator;

import java.util.NoSuchElementException;

public class MyArray implements MyIterator {
	private int[] arr;
	private int index;
	
	public MyArray(int[] x) {
		arr = x;
		index = 0;
	}
	@Override
	public boolean hasNext() {
		return index < arr.length;
	}

	@Override
	public int next() {
		if(!hasNext())
			throw new NoSuchElementException();
		return arr[index++];
	}
}