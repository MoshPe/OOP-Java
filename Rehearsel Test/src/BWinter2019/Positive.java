package BWinter2019;

public class Positive implements Function {
	private Function f;

	public Positive(Function f) {
		this.f = f;
	}

	@Override
	public int getValue(int x) throws OutOfDomainException {
		return x > 0 ? f.getValue(x) : 0;
	}

	@Override
	public int getDomainStart() {
		return f.getDomainStart();
	}

	@Override
	public int getDomainEnd() {
		return f.getDomainEnd();
	}

	public static void main(String[] args) throws OutOfDomainException {
		Function f = new Positive(new DoubleFunction());
		System.out.println(f.getValue(3));
		System.out.println(f.getValue(-2));
	}

}
