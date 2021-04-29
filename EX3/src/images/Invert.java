package images;

public class Invert extends ImageDecorator{
	private Image base;
	public Invert(Image base) {
		super(base.getWidth(),base.getHeight());
		this.base = base;	
	}
	
	@Override
	public RGB get(int x, int y) {
		if(x > base.getWidth() || y > getHeight())
			return null;
		return base.get(x, y).invert();
	}
	/*
	public static void main(String[] argc) {
		Image i = new Invert(new Circle(120, 60, RGB.RED, RGB.BLACK));
		//Image i2 = new Circle(120, 60, RGB.RED, RGB.BLACK);
		Displayer.display(i);
	}
	*/
}
