package ex;

public class Util {

	public static int sumScores(Scorer[] ss, int n){
		try {
			int sum = 0;
			for (Scorer scorer : ss) {
				sum += scorer.score(n);
			}
			return sum;
		} catch (ScorerException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
