package iterator;

import java.util.Iterator;

public class Combined<E> implements Iterable<E>{
	private Iterable<E> first, second;
	
	public Combined(Iterable<E> first, Iterable<E> second) {
		this.first = first;
		this.second = second;
	}
	
	private class CombinedIteratable implements Iterator<E>{
		private int switchFlag = 0;
		private Iterator<E> a = first.iterator(),b = second.iterator();
		@Override
		public boolean hasNext() {
			return a.hasNext() || b.hasNext();
		}

		@Override
		public E next() {
			if(!hasNext())
				throw new IndexOutOfBoundsException();
			if(switchFlag++ % 2 == 0 && a.hasNext())
				return a.next();
			if(!b.hasNext())
				return a.next();
			return b.next();
		}
		
	}
	@Override
	public Iterator<E> iterator() {
		return new CombinedIteratable();
	}

}
