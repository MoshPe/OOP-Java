package a;

import java.util.Iterator;

public class ahhhh {
	public static void main(String[] args) {
		Array2DWithIterator<String> a2 = new Array2DWithIterator<>(3, 3);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				a2.set(i, j, "E" + i + j);
			}
		}
		Iterator<String> i = a2.iterator();
		while(i.hasNext()) {
			System.out.print(i.next() + " ,");
		}
		System.out.println();
		for (String string : a2) {
			System.out.print(string + " ,");
		}
	}
}
