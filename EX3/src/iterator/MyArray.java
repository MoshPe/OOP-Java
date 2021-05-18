package iterator;

import java.util.NoSuchElementException;

//this class represent array with special methods 
public class MyArray implements MyIterator {

	private int[] array;
	private int index;

	public MyArray(int[] array) { // set the array
		this.array = array;
		index = 0;
	}

	@Override
	public boolean hasNext() { // return true if we didn't reach the end of the array
		return index < array.length;
	}

	@Override
	public int next() {
		if (!hasNext())
			// if we reach the end of the array, throw exception
			throw new NoSuchElementException(); 
		// return the next number in the array
		return array[index++]; 
	}

}
