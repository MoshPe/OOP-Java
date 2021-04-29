package images;

public class Transpose extends ImageDecorator {
	private Image base;
	private int width, height;

	public Transpose(Image base) {
		super(base.getHeight(),base.getWidth());
		this.width = base.getHeight();
		this.height = base.getWidth();
		this.base = base;
	}

	@Override
	public RGB get(int x, int y) {
		if(x > width || y > height)
			return null;
		return base.get(y > width ? width : y, x > height ? height : x);
	}
/*
	public static void main(String[] argc) {
		Image i = new Transpose(new Gradient(100, 200, RGB.BLUE,
				 RGB.GREEN));	
		Displayer.display(i);
	}
*/
}