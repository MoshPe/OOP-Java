package CSpring2020;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class mainIterator {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,7,12,4,1,20,2);
		Iterator<Integer> it = new StartAt(list,11);
		while(it.hasNext())
			System.out.println(it.next() + " ");
	}
}
