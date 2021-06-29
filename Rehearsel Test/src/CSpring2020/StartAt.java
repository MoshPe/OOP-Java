package CSpring2020;

import java.util.Iterator;

public class StartAt implements Iterator<Integer>{
	private Iterator<Integer> iterable;
	private int start;
	private boolean passedStart = false;
	
	public StartAt(Iterable<Integer> iterable, int start) {
		this.iterable = iterable.iterator();
		this.start = start;
	}
	
	@Override
	public boolean hasNext() {
		return iterable.hasNext();
	}

	@Override
	public Integer next() {
		Integer temp = iterable.next();
		while(temp < start && !passedStart)
			temp = iterable.next();
		passedStart = true;
		return temp;
	}
}
