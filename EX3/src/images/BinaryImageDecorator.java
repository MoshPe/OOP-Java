package images;

public abstract class BinaryImageDecorator implements Image {

	private int width,height;
	private BaseImage a;
	
	public BinaryImageDecorator(int width, int height) {
		this.width = width;
		this.height = height;
		a = new BaseImage(width,height);
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
