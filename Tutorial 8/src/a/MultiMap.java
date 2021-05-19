package a;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MultiMap<K,V>{
	Map<K,Set<V>> map = new HashMap<K, Set<V>>();
	
	@SuppressWarnings("serial")
	public void put(K key, V value) {
		if(map.containsKey(key))
			map.get(key).add(value);
		else
			map.put(key, new HashSet<>(){{ add(value); }});
	}
	
	public Collection<V> get(K key){
		return map.get(key);
	}

	public static void main(String[] args) {
		MultiMap<String, Integer> map = new MultiMap<>();
		
		map.put("A",7);
		map.put("B",90);
		map.put("B",100);
		map.put("B",30);
		
		System.out.println(map.get("A"));
		System.out.println(map.get("B"));
	}

}
