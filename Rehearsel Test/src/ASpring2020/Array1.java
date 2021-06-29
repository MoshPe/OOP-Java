package ASpring2020;

import java.util.Iterator;

public class Array1<T> {
	private T[] a;

	public Array1(T[] a) {
		this.a = a;
	}

	private class iterateWithIndex implements Iterator<T> {
		private int[] indexies;
		private int indexTemp = 0;

		public iterateWithIndex(int[] indexies) {
			this.indexies = indexies;
		}

		@Override
		public boolean hasNext() {
			return indexTemp != a.length;
		}

		@Override
		public T next() {
			if(!hasNext())
				throw new IndexOutOfBoundsException();
			return a[indexies[indexTemp++]];
		}

	}

	public Iterator<T> iterator(int[] chosen) {
		return new iterateWithIndex(chosen);
	}

	public static void main(String[] args) {
		String[] strs = { "A", "B", "C", "D", "E", "F" };
		Array1<String> a1 = new Array1<>(strs);
		int[] chosen = {2,1,0,5,2,1};
		Iterator<String> it = a1.iterator(chosen);
		while(it.hasNext())
			System.out.print(it.next());
	}
}
