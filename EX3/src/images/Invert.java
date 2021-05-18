package images;

public class Invert extends ImageDecorator{
	private Image base;
	
	public Invert(Image base) {
		super(base);
		this.base = base;	
	}
	
	@Override
	public RGB get(int x, int y) {
		//checking if the given indexes are legal
		if(x > getWidth() || y > getHeight())
			return null;
		return base.get(x, y).invert();
	}
}
