package a;

import java.util.Collection;

public class TwoWayMultiMap <U,V>{
	MultiMap<U,V> map1 = new MultiMap<>();
	MultiMap<V,U> map2 = new MultiMap<>();

	public void put(U u, V v) {
		map1.put(u, v);
		map2.put(v, u);
	}
	public Collection<V> get1(U u){
		return map1.get(u);
	}
	public Collection<U> get2(V v){
		return map2.get(v);
	}
}
