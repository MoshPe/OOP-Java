package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Maze implements GraphInterface<Place> {
	private Place[][] maze;
	private Place start, end;
	private int matrixSize;

	public Maze(int size, int startx, int starty, int endx, int endy) {
		start = new Place(startx, starty, size);
		end = new Place(endx, endy, size);
		maze = new Place[size][size];
		buildMaze(maze);
		maze[startx][starty] = start;
		maze[endx][endy] = end;
		matrixSize = size;
	}

	private void buildMaze(Place[][] maze) {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++)
				maze[i][j] = new Place(i, j, maze.length);
		}
	}

	public boolean addWall(int x, int y) {
		Place temp = new Place(x, y, maze.length);
		if (temp.equals(start) || temp.equals(end))
			return false;
		maze[x][y] = null;
		return true;
	}

	public boolean isSolvable() throws GraphException {
		Graph<Place> solveMaze = new Graph<>();
		for (Place[] places : maze) {
			for (Place place : places)
				if (place != null)
					solveMaze.addVertex(place);
		}
		for (int i = 0; i < maze.length - 1; i++) {
			for (int j = 0; j < maze[i].length - 1; j++) {
				if (maze[i][j] == null)
					continue;
				if (maze[i][j + 1] != null)
					solveMaze.addEdge(maze[i][j], maze[i][j + 1]);
				if (maze[i + 1][j] != null)
					solveMaze.addEdge(maze[i][j], maze[i + 1][j]);
			}
			if (maze[i][maze[i].length - 1] != null && maze[i + 1][maze[i].length - 1] != null)
				solveMaze.addEdge(maze[i][maze[i].length - 1], maze[i + 1][maze[i].length - 1]);
		}

		for (int j = 0; j < maze[0].length - 1; j++) {
			if (maze[maze.length - 1][j] == null)
				continue;
			if (maze[maze.length - 1][j + 1] != null)
				solveMaze.addEdge(maze[maze.length - 1][j], maze[maze.length - 1][j + 1]);
		}
		return solveMaze.connected(start, end);
	}

	public String toString() {
		StringBuilder returnMaze = new StringBuilder();
		for (Place[] places : maze) {
			for (Place place : places) {
				if (place == null)
					returnMaze.append("@ ");
				else if (place.equals(start))
					returnMaze.append("S ");
				else if (place.equals(end))
					returnMaze.append("E ");
				else
					returnMaze.append(". ");
			}
			returnMaze.append("\n");
		}
		return returnMaze.toString();
	}

	@Override
	public Collection<Place> neighbours(Place v) {
		Collection<Place> neighbour = new ArrayList<>();
		int getX = v.getX(), getY = v.getY();
		if (getY + 1 < matrixSize && maze[getX][getY + 1] != null)
			neighbour.add(maze[getX][getY + 1]);

		if (getY - 1 >= 0 && maze[getX][getY - 1] != null)
			neighbour.add(maze[getX][getY - 1]);

		if (getX + 1 < matrixSize && maze[getX + 1][getY] != null)
			neighbour.add(maze[getX + 1][getY]);

		if (getX - 1 >= 0 && maze[getX - 1][getY] != null)
			neighbour.add(maze[getX - 1][getY]);
		return neighbour;
	}
	
	/*
	public static void main(String[] args) throws GraphException {
		Maze m = new Maze(4, 0, 0, 3, 3);
		 m.addWall(1, 1);
		 m.addWall(3, 1);
		 m.addWall(0, 1);
		 m.addWall(2, 3);
		 m.addWall(2, 3);
		 //m.addWall(3, 2);
		 m.addWall(1, 3);
		System.out.println(m);
		System.out.println(m.isSolvable());
		ConnectionChecker<Place> cc = new ConnectionChecker<>(m);
		System.out.println(cc.check(new Place(0, 0, 4), new Place(3, 3, 4)));
	}
	*/
}
