package BWinter2019;

public class DoubleFunction implements Function {
	private int start = -3, end = 3;

	@Override
	public int getValue(int x) throws OutOfDomainException {
		if (x > end || x < start)
			throw new OutOfDomainException();
		return 2 * x;
	}

	@Override
	public int getDomainStart() {
		return start;
	}

	@Override
	public int getDomainEnd() {
		return end;
	}
}
