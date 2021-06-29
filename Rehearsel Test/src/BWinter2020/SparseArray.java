package BWinter2020;

import java.util.HashMap;
import java.util.Map;

public class SparseArray <E>{
	Map<Integer,E> map = new HashMap<>();
			
	public E set(int i, E e) {
		E temp = get(i);
		if(temp != null)
			map.remove(i);
		map.put(i, e);
		return temp;
	}
	
	public E get(int i) {
		return map.get(i);
	}
	
	public static void main(String[] args) {
		SparseArray<String> s = new SparseArray<>();
		System.out.println((s.set(10, "First") + " "));
		System.out.println((s.set(20000, "Second") + " "));
		System.out.println((s.get(10) + " "));
		System.out.println((s.get(100) + " "));
		System.out.println((s.get(20000) + " "));
	}
}
