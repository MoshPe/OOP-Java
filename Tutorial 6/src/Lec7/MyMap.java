package Lec7;

import java.util.ArrayList;
import java.util.List;

public class MyMap <K,V>{
	private List<K> keys = new ArrayList<>();
	private List<V> values = new ArrayList<>();
	
	public void put(K key, V value){
		if(key == null || value == null)
			throw new NullPointerException();
		keys.add(key);
		values.add(value);
		
	}
	public V get(K key) {	return values.get(keys.indexOf(key));	}
	
	public static void main(String[] args) {
		MyMap<String, Integer> map = new MyMap<>();
		
		map.put("one", 1);
		map.put("three", 3);
		map.put("seven", 7);
		map.put("four", 4);
		System.out.println(map.get("seven"));
	}
}
