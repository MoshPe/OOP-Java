package ex;

public class sdgasgdscv {
	public static void main(String[] argc) throws ScorerException {
		try {
			Scorer[] ss = new Scorer[3];
			ss[0] = new DivideScorer(2);
			ss[1] = new DivideScorer(3);
			ss[2] = new SquareScore();
			System.out.println(Util.sumScores(ss, -1));
		} catch (ScorerException e) {
			e.printStackTrace();
		}
	}
}