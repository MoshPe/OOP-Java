package iterator;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class mainIterator {
	public static void main(String[] args) {
		int[] a1 = { 1, 2, 3, 4 };
		int[] a2 = { 100, 101, 102, 103, 104, 105, 106 };
				
		TwoArrays aa = new TwoArrays(a1, a2);
		for (int i : aa) 
			System.out.print(i + " ");

		List<String> list = Arrays.asList("one", "two", "three");
		Set<String> set = new TreeSet<>();
		set.addAll(Arrays.asList("B", "A", "D", "C", "E"));
		Combined<String> c = new Combined<>(set, list);
		//System.out.println(c.iterator().next());
				for (String s : c) 
			System.out.print(s + " ");
	}
}
