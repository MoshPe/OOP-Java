package function;

public class square implements Function {

	@Override
	public int function(int n) {
		if(n > upperBound())
			throw new IndexOutOfBoundsException();
		return n * n;
	}

	@Override
	public int upperBound() {
		return 100;
	}
}
