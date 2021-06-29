package BWinter2019;

import java.util.Arrays;
import java.util.Iterator;

public abstract class FunctionDecorator implements Function{
	protected Function f;

	public FunctionDecorator(Function f) {
		this.f = f;
	}

	public abstract int getValue(int x) throws OutOfDomainException;

	@Override
	public int getDomainStart() {
		return f.getDomainStart();
	}

	@Override
	public int getDomainEnd() {
		return f.getDomainEnd();
	}
	
	private class DecoratorIterator implements Iterator{
		private int start = getDomainStart();
		
		@Override
		public boolean hasNext() {
			return start != getDomainEnd();
		}

		@Override
		public int[] next() {
			if(!hasNext())
				throw new IndexOutOfBoundsException();
			int[] temp = new int[2];
			temp[0] = start;
			try {
				temp[1] = this.getValue(start++);
			} catch (OutOfDomainException e) {
			}
			return temp;
		}
	}
	
	public DecoratorIterator iterator() {
		return new DecoratorIterator();
	}
	
	@Override
	public String toString() {
		StringBuilder temp = new StringBuilder();
		Iterator<int[]> a = iterator();
		temp.append(Arrays.toString(a.next()));
		while(a.hasNext()) {
			temp.append(" ,");
			temp.append(Arrays.toString(a.next()));
		}
		return temp.toString();
	}
}
