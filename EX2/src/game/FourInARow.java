package game;

//this class represent a Four in a row game, subclass of Game class
public class FourInARow extends Game {

	public FourInARow(String player1, String player2) { // constructor
		super(6, 7, new Player(player1, 'W'), new Player(player2, 'B'));	//set a game with 6*7 board with 2 players
	}
	
	@Override
	protected boolean doesWin(int i, int j) {	//check if the player win in the game, override the superclass method
		return maxLineContaining(i, j) == 4;	//in four in a row, the player win if he have 4 marks in one line
	}

	@Override
	protected boolean onePlay(Player p) {	//this method represent one play for the player, override the superclass method
		int getCol, row;
		do {
			row = 0;
			System.out.format("%s, please enter a colum to play\n", p);
			getCol = s.nextInt();
			while (row != n && isEmpty(row, getCol))	//reach the empty spot in the column that the player type
				row++;
			if (row != 0) {	//if there is empty spot (i==0 if the top of the column isn't NULL)
				set(row - 1, getCol, p);
				System.out.println(this);	//print the board
				return doesWin(row - 1, getCol);	//return if the player won or not
			} else
				System.out.format("%s, the colum is full, try again.\n", p);
		} while (true);
	}

}
