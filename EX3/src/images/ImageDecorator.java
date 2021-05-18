package images;

public abstract class ImageDecorator implements Image {
	
	private int width,height;

	public ImageDecorator(Image Base) {
		width = Base.getWidth();
		height = Base.getHeight();
	}
	public ImageDecorator(int width, int height) {
		this.width = width;
		this.height = height;
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
