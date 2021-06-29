package Threads;

public class prizes {
	private int[] needed;

	public prizes(int[] needed) {
		this.needed = needed;
	}

	public Account makeAccount() {
		return new Account() {
			private int score = 0;
			private int[] prizes = needed;

			@Override
			public void incScore() {
				score++;
			}

			@Override
			public int getScore() {
				return score;
			}

			@Override
			public int prize() {
				int getPrize = 0;
				for (int i = 0; i < prizes.length; i++)
					if (score < prizes[i]) {
						getPrize = i;
						break;
					}
				if(score >= prizes[prizes.length-1])
					getPrize = prizes.length;
				return getPrize;
			}

		};
	}

	public static void main(String[] args) {
		prizes pri = new prizes(new int[] { 2, 5 });
		Account a1 = pri.makeAccount();
		for (int i = 0; i < 8; i++) {
			System.out.println(a1.getScore() + ":" + a1.prize() + " ");
			a1.incScore();
		}
	}
}
