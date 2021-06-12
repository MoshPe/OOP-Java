package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Mines {
	private Place[][] minesGame;
	private int width, height;
	private boolean showAll = false;

	public Mines(int height, int width, int numMines) {
		minesGame = new Place[height+2][width+2];
		this.height = height;
		this.width = width;
		createGame();
		addRndMines(numMines);
	}

	private void createGame() {
		for (int i = 1; i < minesGame.length - 1; i++) {
			for (int j = 1; j < minesGame[i].length - 1; j++)
				minesGame[i][j] = new Place(i-1, j-1);
		}
		
		for (int i = 1; i < minesGame.length - 1; i++) {
			for (int j = 1; j < minesGame[i].length - 1; j++)
				minesGame[i][j].neighbors = getNeighbors(i-1, j-1);
		}
	}
	
	public boolean addMine(int i, int j) {
		if(minesGame[i+1][j+1].isMine == true)
			return false;
		minesGame[i+1][j+1].isMine = true;
		return true;
	}
	
	public boolean open(int i, int j) {
		int count = countMineNeighb(minesGame[i+1][j+1].neighbors);
		if(minesGame[i+1][j+1].isMine == true)
			return false;
		minesGame[i+1][j+1].isOpen = true;
		if(count == 0) {
			for (Place place : minesGame[i+1][j+1].neighbors) {
				if(place != null && place.isOpen == false)
					open(place.getHeight(),place.getWidth());
			}
		}
		return true;
	}
	
	private int countMineNeighb(ArrayList<Place> neighbors) {
		int minesCounter = 0;
		for (Place place : neighbors) {
			if(place != null && place.isMine == true)
				minesCounter++;
		}
		return minesCounter;
	}

	private ArrayList<Place> getNeighbors(int i, int j){
		int x = i + 1;
		int y = j + 1;
		ArrayList<Place> neighbors = new ArrayList<Place>();
		Collections.addAll(neighbors, minesGame[x][y-1],minesGame[x][y+1],
									  minesGame[x+1][y-1],minesGame[x+1][y],
									  minesGame[x+1][y+1],minesGame[x-1][y-1],
									  minesGame[x-1][y],minesGame[x-1][y+1]);
		return neighbors;
	}
	
	public void toggleFlag(int x, int y) {
		minesGame[x+1][y+1].toggleFlag = !minesGame[x+1][y+1].toggleFlag;
	}
	
	public String get(int i, int j) {
		Integer count = countMineNeighb(minesGame[i+1][j+1].neighbors);
		if(minesGame[i+1][j+1].isOpen != true && !showAll) {
			if(minesGame[i+1][j+1].toggleFlag == true)
				return "F";
			return ".";
		}
		else {
			if(minesGame[i+1][j+1].isMine == true)
				return "X";
			 if(count > 0)
				return count.toString();
			return " ";	
		}
	}
	
	public void setShowAll(boolean showAll) {
		this.showAll = showAll;
	}
	
	public String toString() {
		StringBuilder hello = new StringBuilder();
		for (int i = 1; i < minesGame.length - 1; i++) {
			for (int j = 1; j < minesGame[i].length - 1; j++)
				hello.append(get(i - 1,j - 1));
			hello.append('\n');
		}
		return hello.toString();
	}
	
	
	private class Place {
		private int placeHeight;
		private int placeWidth;
		private boolean isMine = false;
		private boolean isOpen = false;
		private boolean toggleFlag = false;
		private ArrayList<Place> neighbors;

		public Place(int height, int width) {
			placeHeight = height;
			placeWidth = width;
		}
		
		public int getHeight() { return placeHeight; }

		public int getWidth() { return placeWidth; }
	}
	
	private void addRndMines(int minesAmount) {
		Random random = new Random();
		for (int j = 0; j < minesAmount; j++) {
			addMine(random.nextInt(height),random.nextInt(width));
		}
	}
	
	public boolean isDone() {
		for (int i = 1; i < minesGame.length - 1; i++)
			for (int j = 1; j <  minesGame[i].length - 1; j++) {
				if (!minesGame[i][j].isMine && !minesGame[i][j].isOpen)
					return false;
			}
		return true;
	}
	
	public static void main(String[] args) {
		Mines m = new Mines(3, 4, 0);
		m.addMine(0, 1);
		m.addMine(2, 3);
		m.open(2, 0);
		System.out.println(m);
		m.toggleFlag(0, 1);
		System.out.println(m);
		System.out.println(m.isDone());


	}
}
