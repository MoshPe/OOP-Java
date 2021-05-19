package graph;

public class Place {
	private int x, y;

	public Place(int x, int y, int bound) {
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
	public int hashCode(Place place) {
		return (int) Math.pow(x, y);
	}
	public boolean equals(Place place) {
		return this.hashCode() == place.hashCode();
	}
}
