package game;

//this class is for a game board
public class Board {

	protected Player[][] board;
	protected int n, m;

	public Board(int n, int m) {
		board = new Player[n][m];
		this.n = n;
		this.m = m;
	}

	protected boolean set(int i, int j, Player p) {
		if (!isEmpty(i, j)) // if the board in i,j is not empty
			return false;
		board[i][j] = p; // else, set player p in there
		return true;
	}

	public boolean isEmpty(int i, int j) {
		return board[i][j] == null;
	}

	public Player get(int i, int j) {
		return board[i][j];
	}

	public boolean isFull() {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (isEmpty(i, j))
					return false; // if it find empty spot the board not empty
		return true;
	}

	// simple toString function to see the boards
	public String toString() {
		String strBoard = "";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				if (get(i, j) != null)
					strBoard += get(i, j).getMark();
				else
					strBoard += ".";
			strBoard += "\n";
		}
		return strBoard;
	}

	/*
	 * this function get (i,j) spot in the board, unit vector and a player, and
	 * check the maximum straight line length in the unit vector direction on the
	 * board that contains the same player as in the (i,j) spot
	 */

	private int getOneDirectionLineLength(int i, int j, int xWay, int yWay, Player p) {
		if (!(i + xWay < 0 || j + yWay < 0 || i + xWay >= n || j + yWay >= m)) // if we don't reach out of the matrix
																				// bound
			if (get(i + xWay, j + yWay) == p) // check if the next spot is with the same player
				// then 1+ for the player and calling the function again with the next spot in
				// the direction of the unit vector
				return 1 + getOneDirectionLineLength(i + xWay, j + yWay, xWay, yWay, p);
		return 0; // out of bound zone
	}

	protected int maxLineContaining(int i, int j) {
		int row, column, mainDiagonal, secondaryDiagonal;
		Player temp = get(i, j);
		// get max spots with the player temp in the row
		row = getOneDirectionLineLength(i, j, 0, 1, temp) + getOneDirectionLineLength(i, j, 0, -1, temp);
		// then column
		column = getOneDirectionLineLength(i, j, 1, 0, temp) + getOneDirectionLineLength(i, j, -1, 0, temp);
		// and main diagonal
		mainDiagonal = getOneDirectionLineLength(i, j, 1, 1, temp) + getOneDirectionLineLength(i, j, -1, -1, temp);
		// secondary diagonal
		secondaryDiagonal = getOneDirectionLineLength(i, j, -1, 1, temp) + getOneDirectionLineLength(i, j, 1, -1, temp);
		// 1+ for the (i,j) and the max among them
		return 1 + Math.max(Math.max(column, row), Math.max(mainDiagonal, secondaryDiagonal));
	}

}
