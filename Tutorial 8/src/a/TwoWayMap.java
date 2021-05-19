package a;

import java.util.HashMap;
import java.util.Map;

public class TwoWayMap <U,V>{
	private Map<U,V> map = new HashMap<U,V>();
	private Map<V,U> map2 = new HashMap<V,U>();
	
	
	public void put(U u, V v) throws Exception {
		if(map.containsKey(u) || map2.containsKey(v))
			throw new IllegalArgumentException();
		map.put(u, v);
		map2.put(v, u);
	}
	
	public V get1(U u) {
		return map.get(u);
	}
	public U get2(V v) {
		return map2.get(v);
	}
}
