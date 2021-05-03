package images;

public abstract class BinaryImageDecorator implements Image {

	private int width,height;
	
	public BinaryImageDecorator(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public BinaryImageDecorator() {
		this.width = 600;
		this.height = 300;
	}
	
	@Override
	public int getWidth() {
		return width; 
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public abstract RGB get(int x, int y);
}
