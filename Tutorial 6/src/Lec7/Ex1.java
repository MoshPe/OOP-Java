package Lec7;

public class Ex1 {
	public static <E> E mostCommon(E[] elements) {
		int maxCounter = 0;
		int secCounter = 0;
		E mostCommonE = null;
		for (E e : elements) {
			for (E i : elements) {
				if(e.equals(i))
					maxCounter++;
			}
			if(maxCounter > secCounter) {
				mostCommonE = e;
				secCounter = maxCounter;
			}
			maxCounter = 0;
		}
		return mostCommonE;
	}
}
