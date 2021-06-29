package Winter2018;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GeneralFunction<T> implements Function<T> {
	protected Map<T, T> field = new HashMap<T, T>();

	public GeneralFunction(Map field) {
		this.field = field;
	}

	private class Iterate implements Iterator<T> {
		Set<T> keySet = field.keySet();

		@Override
		public boolean hasNext() {
			return keySet.iterator().hasNext();
		}

		@Override
		public T next() {
			return keySet.iterator().next();
		}

	}

	@Override
	public Iterator<T> iterator() {
		return new Iterate();
	}

	@Override
	public boolean add(T x, T y) {
		if (!field.containsKey(x)) {
			field.put(x, y);
			return true;
		}
		return false;
	}

	@Override
	public Integer evaluate(T x) {
		return (Integer) field.get(x);
	}

}
