package images;

public class Filter extends ImageDecorator {
	private Image base;
	private RGB filter;

	public Filter(Image base, RGB filter) {
		super(base.getWidth(),base.getHeight());
		this.base = base;
		this.filter = filter;	
	}

	@Override
	public RGB get(int x, int y) {
		if(x > getWidth() || y > getHeight())
			return null;
		return base.get(x, y).filter(filter);
	}
/*
	public static void main(String[] argc) {
	Image i = new Circle(120, 60, RGB.WHITE, RGB.BLACK);
	Image i2 = new Filter(i, new RGB(0.5, 0, 1));
	Displayer.display(i2);
	}
*/
}