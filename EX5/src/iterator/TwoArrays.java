package iterator;

import java.util.Iterator;

public class TwoArrays implements Iterable<Integer>{
	private int a1[],a2[];
	
	public TwoArrays(int[] a1, int[] a2) {
		this.a1 = a1;
		this.a2 = a2;
	}
	
	private class TwoArraysIterator implements Iterator<Integer>{
		
		private int a1Size = 0,a2Size = 0, switchFlag = 0;

		@Override
		public boolean hasNext() {
			return a1Size < a1.length || a2Size < a2.length;
		}

		@Override
		public Integer next() {
			if(!hasNext())
				throw new IndexOutOfBoundsException();
			if(switchFlag++ % 2 == 0 && a1Size != a1.length)
				return a1[a1Size++];
			if(a2Size == a2.length)
				return a1[a1Size++];
			return a2[a2Size++];
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		return new TwoArraysIterator();
	}
}
