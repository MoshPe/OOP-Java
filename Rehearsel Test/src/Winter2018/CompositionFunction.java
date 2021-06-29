package Winter2018;

import java.util.List;
import java.util.Map;

public class CompositionFunction<T> extends GeneralFunction<T>{
	private List<Function> functions;
	
	
	public CompositionFunction(Map field, List<Function> list) {
		super(field);
		functions = list;
	}
	
	public CompositionFunction(Map field) {
		super(field);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean add(T x, T y) {
		throw new UnsupportedOperationException();
	}

}
