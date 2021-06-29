package PreTest;

import java.util.ArrayList;
import java.util.List;

public class HasValueMain<E> {

	public static <E extends HasValue> List<E> filter(List<E> valueList, int atLeast){
		List<E> returnAtLeast = new ArrayList<E>();
		for (E e : valueList) {
			if(e.value() >= atLeast)
				returnAtLeast.add(e);
		}
		return returnAtLeast;
	}
}
