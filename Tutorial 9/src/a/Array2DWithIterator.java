package a;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Array2DWithIterator <E> extends Array2DBase<E> implements Iterable<E>{

	public Array2DWithIterator(int sizeX, int sizeY) {
		super(sizeX, sizeY);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unused")
	private class Iterator2D implements Iterator<E>{
		private int currIndexX = 0;
		private int currIndexY = 0;

		@Override
		public boolean hasNext() {
			return !(sizeX - currIndexX == 1 && sizeY - currIndexY == 0);
		}

		@Override
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			if (currIndexY == sizeY) {
				currIndexY = 0;
				currIndexX++;
			}
			return get(currIndexX, currIndexY++);
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator2D();
	}
}
