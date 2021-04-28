package cards;

public class test {

	public static void main(String[] args) {
		Deck d = new Deck(5);
		System.out.println(d);
		for (int i = 0; i < 3; i++) {
			Deck d2 = new Deck(d, d.getNumCards()/2);
			Deck d3 = new Deck(d, d2);
			d = d3;
		}
		System.out.println(d);
	}

}
