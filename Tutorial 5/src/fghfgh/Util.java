package fghfgh;

public class Util {
	public static void reportAll(int[] a, Reporter[] rs) {
		for (int i = 0; i < a.length; i++) {
			System.out.println("a["+i+"] = " + a[i]);
			for (int j = 0; j < rs.length; j++) {
				rs[j].addNumber(a[i]);
			System.out.format("    %s : %d%n", rs[j],rs[j].report());
			}
		}
	}
}
