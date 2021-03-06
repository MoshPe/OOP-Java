package ex;

public class SquareScore implements Scorer{

	@Override
	public int score(int n) throws ScorerException {
		if(n < 0)
			throw new ScorerException();
		double x = Math.sqrt(n);
		return x - Math.floor(x) == 0 ? 3 : 0;
	}
}
