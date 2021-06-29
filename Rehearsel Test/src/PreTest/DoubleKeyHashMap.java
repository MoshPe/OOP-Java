package PreTest;

import java.util.HashMap;
import java.util.Map;

public class DoubleKeyHashMap<K,V> {
	private Map<K,Map<K,V>> doubleDouble = new HashMap<>();
	
	public void put(K k1, K k2, V v) {
		Map<K,V> temp = doubleDouble.get(k1);
		if(temp == null) {
			temp = new HashMap<>();
			temp.put(k2, v);
			doubleDouble.put(k1, temp);
		}
		else 
			temp.put(k2, v);
	}
	
	public V get(K k1, K k2) {
		Map<K,V> temp = doubleDouble.get(k1);
		if(temp == null)
			return null;
		return temp.get(k2);
	}

}
