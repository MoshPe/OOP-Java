package ASpring2020;

public class IndexOf {

	public static int indexOf(Object[] a, Object o) {
		for (int i = 0; i < a.length; i++) {
			try {
				if (o.equals(a[i]))
					return i;
			} catch (Exception e) {
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Integer[] a = { 3, 9, 11, 5, 12, 3, 6 };
		int i = indexOf(a, new Object() {
			@Override
			public boolean equals(Object obj) {
				Integer other = (Integer) obj;
				return other % 2 == 0;
			}
		});
		System.out.println(i);
	}

}
