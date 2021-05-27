package equiv;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//This class represent an equilibrium department

public class Equiv<E> {
	 private List<Set<E>> list = new ArrayList<>(); // list of sets

	 public void add(E e1, E e2) {
            // get each set in the set, check if one of the types is in department
            Set<E> e1Set = null, e2Set = null;
            for (Set<E> set : list) {
                if (set.contains(e1)) {
                    set.add(e2);
                    e1Set = set;
                }
                else if (set.contains(e2)) {
                    set.add(e1);
                    e2Set = set;
                }
            }
            if(e1Set != null && e2Set != null){
                e1Set.addAll(e2Set);
                list.remove(e2Set);
            }
            // else, make new department with both of them
            else if(e1Set == null && e2Set == null) {
                Set<E> temp = new HashSet<>();
                temp.add(e2);
                temp.add(e1);
                list.add(temp);
            }
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
