package images;

public abstract class BaseImage implements Image {
	
	private int width, height;

	public BaseImage(int width, int height) {
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
