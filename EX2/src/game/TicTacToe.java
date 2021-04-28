package game;

//this class represent a Tic-tac-toe game, subclass of Game class
public class TicTacToe extends Game {

	public TicTacToe(String player1, String player2) {
		super(3,3,new Player(player1, 'X'),new Player(player2, 'O'));	//set a game with 3*3 board with 2 players
	}
	
	@Override
	protected boolean doesWin(int x, int y) { //check if the player win in the game, override the superclass method
		return maxLineContaining(x,y) == 3;	//in Tic-tac-toe, the player win if he have 3 marks in one line
	}
}
