package equiv;

import java.util.HashSet;
import java.util.Set;

//This class represent an equilibrium department

public class Equiv<E> {
	private Set<Set<E>> list = new HashSet<>(); // set of sets

	public void add(E e1, E e2) {
		// get each set in the set, check if one of the types is in department
		for (Set<E> set : list) { 
			if (set.contains(e1) && !set.contains(e2))
				set.add(e2);
			else if (!set.contains(e1) && set.contains(e2))
				set.add(e1);
			else if (set.contains(e1) && set.contains(e2))
				return;
		}
		// else, make new department with both of them
		Set<E> temp = new HashSet<>();
		temp.add(e2);
		temp.add(e1);
		list.add(temp);

	}

	// check if e1 and e2 are in the same department
	public boolean are(E e1, E e2) {
		if (e1.equals(e2) && e2.equals(e1))
			return true;
		for (Set<E> set : list)
			if (set.contains(e2) && set.contains(e1)) // if we found set (department) with both of them, it's true
				return true;
		return false;
	}
}
