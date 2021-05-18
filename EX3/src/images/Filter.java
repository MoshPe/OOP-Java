package images;

public class Filter extends ImageDecorator {
	private Image base;
	private RGB filter;

	public Filter(Image base, RGB filter) {
		super(base);
		this.base = base;
		this.filter = filter;	
	}

	@Override
	public RGB get(int x, int y) {
		//checking if the given indexes are legal
		if(x > getWidth() || y > getHeight())
			return null;
		return base.get(x, y).filter(filter);
	}
}
