package images;

public class Transpose extends ImageDecorator {
	private Image base;

	public Transpose(Image base) {
		super(base.getHeight(),base.getWidth());
		this.base = base;
	}

	@Override
	public RGB get(int x, int y) {
		if(x > getWidth() || y > getHeight())
			return null;
		return base.get(y > getWidth() ? getWidth() : y, x > getHeight() ? getHeight() : x);
	}

	public static void main(String[] argc) {
		Image i = new Transpose(new Gradient(100, 200, RGB.BLUE,
				 RGB.GREEN));	
		Displayer.display(i);
	}

}
