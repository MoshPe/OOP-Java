package AWinter2020CheatSheet;

import java.util.Iterator;

public class Array2 implements Iterable<Pair> {
	private int[] a;

	public Array2(int[] a) {
		this.a = a;
	}

	@Override
	public Iterator<Pair> iterator() {
		return new Iterator<Pair>() {
			private int allX = 0, allY = allX+1;

			@Override
			public boolean hasNext() {
				return !(allX + 2 == a.length && allY == a.length);
			}

			@Override
			public Pair next() {
				if (!hasNext())
					throw new IndexOutOfBoundsException();
				if (allY == a.length) {
					allX++;
					allY = allX+1;
				}
				return new Pair(a[allX], a[allY++]);
			}

		};
	}

	public static void main(String[] args) {
		Array2 arr = new Array2(new int[] { 1, 3, 5, 7 });
		for (Pair pair : arr) {
			System.out.println(pair + " ");
		}
	}

}
