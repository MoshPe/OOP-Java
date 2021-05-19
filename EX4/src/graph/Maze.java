package graph;

public class Maze {
	private Place[][] maze;
	private Place start, end;

	public Maze(int size, int startx, int starty, int endx, int endy) {
		start = new Place(startx, starty, size);
		end = new Place(endx, endy, size);
		maze = new Place[size][size];
		maze[startx][starty] = start;
		maze[endx][endy] = end;
	}

	public boolean addWall(int x, int y) {
		Place temp = new Place(x, y ,maze.length);
		if(temp.equals(start) || temp.equals(end) || maze[x][y] != null)
			return false;
		maze[x][y] = temp;
		return true;

	}

	public String toString() {
		StringBuilder returnMaze = new StringBuilder();
		for (Place[] places : maze) {
			for (Place place : places) {
				if(place == null)
					returnMaze.append(". ");
				else if(place.equals(start))
					returnMaze.append("S ");
				else if(place.equals(end))
					returnMaze.append("E ");
				else 
					returnMaze.append("@ ");
					
			}
			returnMaze.append("\n");
		}
		return returnMaze.toString();
	}
	
	public static void main(String[] args) {
		Maze m = new Maze(4, 0, 0, 3, 3);
		 m.addWall(1, 1);
		 m.addWall(3, 1);
		 m.addWall(0, 1);
		 m.addWall(2, 3);
		 m.addWall(2, 3);
		 m.addWall(1, 3);
		 System.out.println(m);
	}
}
