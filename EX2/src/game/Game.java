package game;

import java.util.Scanner;

//this class represent a game, subclass of Board class
public class Game extends Board {

	protected Player[] players;
	protected Scanner s;

	public Game(int n, int m, Player p1, Player p2) {	//constructor
		super(n, m);
		players = new Player[2];
		players[0] = p1;
		players[1] = p2;
		s = new Scanner(System.in);
	}

	protected boolean doesWin(int i, int j) {
		return (i == j && i == 0);
	}

	protected boolean onePlay(Player p) {
		int x, y;
		do {
			System.out.format("%s, please enter x and y:\n", p);
			x = s.nextInt(); //x
			y = s.nextInt(); //y
			if (x > n || x < 0 || y > m || y < 0)
				System.out.println("Wrong indexes, please try again");
			else {
				if (!set(x, y, p))	//try to set the move, if the place is full print message 
					System.out.format("There is a piece there already...\n");
				else {	//else, we set the player
					System.out.println(this);	//print the board
					return doesWin(x,y); //return if the player win or not
					}
				}
		} while (true);
	}

	public Player play() {
		int i = 0;
		do {
			if (isFull()) {	//if the board is full, close s and return null
				s.close();
				return null;
			}
			if (onePlay(players[i % 2])) {	//if the player win, close s and return the player
				s.close();
				return players[i % 2];
			}
			i++;
		} while (true);
	}
}
