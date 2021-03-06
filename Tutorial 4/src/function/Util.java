package function;

public class Util {
	public static int sum(int n, Function func) {
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += func.function(i);
		return sum;
	}
	
	public static int sum(Function func) {
		return sum(func.upperBound(),func);
	}
}
