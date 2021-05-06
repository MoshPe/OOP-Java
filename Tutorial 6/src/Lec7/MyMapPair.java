package Lec7;

import java.util.ArrayList;
import java.util.List;

public class MyMapPair <K,V> {
	private List<Pair<K,V>> maps = new ArrayList<>();
	
	public void put(Pair<K,V> temp) {
		maps.add(temp);
	}
	
	public V get(K key) {
		int index = maps.indexOf(new Pair<>(key,null));
		return maps.get(index).get2();
	}
}
