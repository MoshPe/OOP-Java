package graph;

import java.util.ArrayList;
import java.util.Collection;

//This class represent an implementation of a maze
public class Maze implements GraphInterface<Place> {
	private Place[][] maze;
	private Place start, end;

	public Maze(int size, int startx, int starty, int endx, int endy) {
		start = new Place(startx, starty, size);
		end = new Place(endx, endy, size);
		//making a matrix size x size of Place instances
		maze = new Place[size][size];
		buildMaze(maze);
		maze[startx][starty] = start;
		maze[endx][endy] = end;
	}

	//for each item in the matrix we make a new place with its attributes
	private void buildMaze(Place[][] maze) {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++)
				maze[i][j] = new Place(i, j, maze.length);
		}
	}

	/*
		for each wall the item in the matrix will be initialize to null
		for better detection in toString and isSolvable functions
	*/
	public boolean addWall(int x, int y) {
		Place temp = new Place(x, y, maze.length);
		if (temp.equals(start) || temp.equals(end) || maze[x][y] == null)
			return false;
		maze[x][y] = null;
		return true;
	}

	//create a graph from the maze's items and check if its solvable
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
			
			//Adding edges to the graph that doesn't contains a wall
			for (int i = 0; i < maze.length - 1; i++) {
				//for each item we connect it to its lower and right item
				for (int j = 0; j < maze[i].length - 1; j++) {
					if (maze[i][j] == null)
						continue;
					if (maze[i][j + 1] != null)
						catchExceptionForEdge(solveMaze, maze[i][j], maze[i][j + 1]);
					if (maze[i + 1][j] != null)
						catchExceptionForEdge(solveMaze, maze[i][j], maze[i + 1][j]);
				}
				//for the last item in the row the function connects it with the lower place only
				if (maze[i][maze[i].length - 1] != null && maze[i + 1][maze[i].length - 1] != null)
					catchExceptionForEdge(solveMaze, maze[i][maze[i].length - 1], maze[i + 1][maze[i].length - 1]);
			}
			
			//for each item in the last row the function connects each item with its next one to the right
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

	//A function to catch all the exception from adding an edge
	private void catchExceptionForEdge(Graph<Place> graph, Place a, Place b) {
		try {
			graph.addEdge(a, b);
		} catch (GraphException g) {
			g.printStackTrace();
		}
	}
	
	//The function adds given item connected vertices 
	@Override
	public Collection<Place> neighbours(Place v) {
		Collection<Place> neighbour = new ArrayList<>();
		int matrixSize = maze.length;
		int getX = v.getX(), getY = v.getY();
		
		//checking the right item
		if (getY + 1 < matrixSize && maze[getX][getY + 1] != null)
			neighbour.add(maze[getX][getY + 1]);
		
		//checking the left item
		if (getY - 1 >= 0 && maze[getX][getY - 1] != null)
			neighbour.add(maze[getX][getY - 1]);
		
		//checking the item below
		if (getX + 1 < matrixSize && maze[getX + 1][getY] != null)
			neighbour.add(maze[getX + 1][getY]);
		
		//checking the item above
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
}
