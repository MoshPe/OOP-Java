package PreTest;

public class PutNull {
	public static <E> void nullAll(E[] a, Predicate<E> p) {
		if (p == null)
			throw new NullPointerException();
		for (E e : a) {
			if(p.f(e))
				e = null;
		}
	}
	
	public static void zero100(Integer[] a) {	
		class predicateInt<E> implements Predicate<E>{

			@Override
			public boolean f(E x) {
				return (Integer) x > 100;
			}	
		}
		predicateInt<Integer> temp = new predicateInt<Integer>();
		PutNull.nullAll(a, temp);
	}
	
	
}
