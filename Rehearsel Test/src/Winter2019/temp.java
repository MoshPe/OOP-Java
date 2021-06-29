package Winter2019;

public class temp {
	public static int apply(int[] a, Func func) {
		for (int i = 1; i < a.length; i++)
			a[i] = func.f(a[i]);
		return 1;
	}
	
	public static int square(int[] a) {
		return apply(a, new Func() {
			@Override
			public int f(int x) {
				return x*x;
			}	
		});
	}
}
