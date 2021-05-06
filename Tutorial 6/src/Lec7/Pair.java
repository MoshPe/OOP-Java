package Lec7;

public class Pair <T1,T2>{
	private  T1 t1;
	private  T2 t2;
	
	public Pair (T1 t1, T2 t2) {
		this.t1 = t1;
		this.t2 = t2;
	}
	
	public T1 get1() {	return t1;	}
	public T2 get2() {	return t2;	}
	
	@Override
	public boolean equals(Object o) {
		@SuppressWarnings("unchecked")
		Pair<T1,T2> other = (Pair<T1,T2>)o;
		return get1().equals(other.get1());
	}
}
