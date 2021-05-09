package images;

public abstract class ImageDecorator extends BaseImage implements Image {
	
	public ImageDecorator(int width, int height) {
		super(width, height);
	}
}
