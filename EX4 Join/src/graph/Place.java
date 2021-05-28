package graph;

//this class represent place in the 2-dimension (x,y)

public class Place {
	private int x, y;

	public Place(int x, int y, int bound) {
		//if x,y are not inside the bound
		if (x < 0 || x >= bound || y < 0 || y >= bound)	
			throw new IllegalArgumentException();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int hashCode() {
		return x * 17 + y * 31;
	}

	@Override
	public boolean equals(Object place) {
		if(place instanceof Place)
			return this.hashCode() == ((Place) place).hashCode();
		return false;
	}
}
