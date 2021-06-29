package BWinter2020;

public class Game {
	private String[] a = new String[10];
	
	public Setter setter(String name, int amount) {
		return new Setter() {
			private int amountToPut = amount;
			private String playerName = name;
			
			@Override
			public void put(int i) {
				if(amountToPut != 0)
					a[i] = playerName;
				amountToPut--;
			}
		};
	}
	
	@Override
	public String toString() {
		StringBuilder returnPlayers = new StringBuilder();
		for (String string : a) {
			returnPlayers.append(string + ", ");
		}
		return returnPlayers.toString();
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		Setter s1 = g.setter("A", 2);
		s1.put(1);
		s1.put(3);
		s1.put(5);
		System.out.println(g);
	}
}
