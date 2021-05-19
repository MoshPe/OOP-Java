package equiv;

import java.util.HashSet;
import java.util.Set;

public class Equiv<E> {
	private Set<Set<E>> list = new HashSet<>();
	
	public void add(E e1, E e2) {
		for (Set<E> set : list) {
			if(set.contains(e1) && !set.contains(e2)) 
				set.add(e2);
			else if(!set.contains(e1) && set.contains(e2))
				set.add(e1);
			else if(set.contains(e1) && set.contains(e2))
				return;
		}
		Set<E> temp = new HashSet<>();
		temp.add(e2);
		temp.add(e1);
		list.add(temp);

	}
	public boolean are(E e1, E e2) {
		if(e1.equals(e2) && e2.equals(e1))
			return true;
		for (Set<E> set : list)
			if(set.contains(e2) && set.contains(e1))
				return true;
		return false;	
	}
	
//	public static void main(String[] args) {
//		Equiv<String> equiv = new Equiv<>();
//		equiv.add("ball", "balloon");
//		equiv.add("child", "person");
//		equiv.add("girl", "child");
//		equiv.add("ball", "sphere");
//		equiv.add("sphere", "circle");
//		equiv.add("dog", "cat");
//
//		System.out.println(equiv.are("balloon", "circle"));
//		System.out.println(equiv.are("child", "girl"));
//		System.out.println(equiv.are("sun", "sun"));	
//		System.out.println(equiv.are("dog", "ball"));
//		System.out.println(equiv.are("table", "dog"));	
//	}
}
