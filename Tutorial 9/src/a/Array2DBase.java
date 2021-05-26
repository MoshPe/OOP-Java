package a;

public class Array2DBase <E>{
	private E[][] matrix;
	protected final int sizeX, sizeY;


	@SuppressWarnings("unchecked")
	public Array2DBase(int sizeX, int sizeY) {
		matrix = (E[][]) new Object[sizeX][sizeY];
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	public void set(int x, int y, E val) {
		matrix[x][y] = val;
	}
	public E get(int x, int y) {
		if(x < 0 || x > sizeX || y < 0 || y > sizeY )
			return null;
		return matrix[x][y];
	}
}
