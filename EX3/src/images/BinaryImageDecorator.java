package images;

public abstract class BinaryImageDecorator extends BaseImage implements Image {

<<<<<<< HEAD
	public BinaryImageDecorator(int width, int height) {
		super(width, height);
=======
	private int width,height;
	private BaseImage a;
	
	public BinaryImageDecorator(int width, int height) {
		this.width = width;
		this.height = height;
		a = new BaseImage(width,height);
>>>>>>> 45633c31d504332900d427aee1e83d3077797f13
	}
}
