package Winter2018;

import java.util.Map;

public class UniqueFunction<T> extends GeneralFunction<T>{

	public UniqueFunction(Map field) {
		super(field);
	}
	
	@Override
	public boolean add(T x, T y) {
		if(field.containsKey(x)) {
			if(field.containsValue(y))
				return false;
		}
		field.put(x, y);
		return true;
	}
}
