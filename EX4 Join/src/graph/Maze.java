package graph;

import java.util.ArrayList;
import java.util.Collection;

public class Maze implements GraphInterface<Place> {
	private Place[][] maze;
	private Place start, end;

	public Maze(int size, int startx, int starty, int endx, int endy) {
		start = new Place(startx, starty, size);
		end = new Place(endx, endy, size);
		maze = new Place[size][size];
		buildMaze(maze);
		maze[startx][starty] = start;
		maze[endx][endy] = end;
	}

	private void buildMaze(Place[][] maze) {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++)
				maze[i][j] = new Place(i, j, maze.length);
		}
	}

	public boolean addWall(int x, int y) {
		Place temp = new Place(x, y, maze.length);
		if (temp.equals(start) || temp.equals(end) || maze[x][y] == null)
			return false;
		maze[x][y] = null;
		return true;
	}

	//add the maze to a graph and check if is solvable
	public boolean isSolvable() {
		Graph<Place> solveMaze = new Graph<>();
		boolean isSolveAble = false;
		
		//add places from the maze to graph vertex
			for (Place[] places : maze) {
				for (Place place : places)
					if (place != null)
						try {
						solveMaze.addVertex(place);
						} catch (GraphException g) {
							g.printStackTrace();
						}
			}
			
			//add for each place the places we can reach from him
			for (int i = 0; i < maze.length - 1; i++) {
				for (int j = 0; j < maze[i].length - 1; j++) {
					if (maze[i][j] == null)
						continue;
					if (maze[i][j + 1] != null)
						catchExceptionForEdge(solveMaze, maze[i][j], maze[i][j + 1]);
					if (maze[i + 1][j] != null)
						catchExceptionForEdge(solveMaze, maze[i][j], maze[i + 1][j]);
				}
				if (maze[i][maze[i].length - 1] != null && maze[i + 1][maze[i].length - 1] != null)
					catchExceptionForEdge(solveMaze, maze[i][maze[i].length - 1], maze[i + 1][maze[i].length - 1]);
			}

			for (int j = 0; j < maze[0].length - 1; j++) {
				if (maze[maze.length - 1][j] == null)
					continue;
				if (maze[maze.length - 1][j + 1] != null)
					catchExceptionForEdge(solveMaze, maze[maze.length - 1][j], maze[maze.length - 1][j + 1]);
				try {
				isSolveAble = solveMaze.connected(start, end);
				} catch (GraphException g) {
					g.printStackTrace();
				}

			}
		return isSolveAble;
	}

	
	private void catchExceptionForEdge(Graph<Place> graph, Place a, Place b) {
		try {
			graph.addEdge(a, b);
		} catch (GraphException g) {
			g.printStackTrace();
		}
	}
	
	@Override
	public Collection<Place> neighbours(Place v) {
		Collection<Place> neighbour = new ArrayList<>();
		int matrixSize = maze.length;
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

	public String toString() {
		StringBuilder returnMaze = new StringBuilder();
		for (Place[] places : maze) {
			for (Place place : places) {
				if (place == null)
					returnMaze.append("@");
				else if (place.equals(start))
					returnMaze.append("S");
				else if (place.equals(end))
					returnMaze.append("E");
				else
					returnMaze.append(".");
			}
			returnMaze.append("\n");
		}
		return returnMaze.toString();
	}

//	public static void main(String[] args) throws GraphException {
//		Maze m = new Maze(4, 0, 0, 3, 3);
//		m.addWall(1, 1);
//		m.addWall(3, 1);
//		m.addWall(0, 1);
//		m.addWall(2, 3);
//		m.addWall(2, 3); // m.addWall(3, 2);
//		m.addWall(1, 3);
//		System.out.println(m);
//		System.out.println(m.isSolvable());
//		ConnectionChecker<Place> cc = new ConnectionChecker<>(m);
//		System.out.println(cc.check(new Place(0, 0, 4), new Place(3, 3, 4)));
//	}

}
