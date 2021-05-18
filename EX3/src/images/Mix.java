package images;

public class Mix extends BinaryImageDecorator{
	private Image base1, base2;
	double alpha;
	
	public Mix(Image base1, Image base2, double alpha) {
		super(base1, base2);
		this.base1 = base1;
		this.base2 = base2;
		this.alpha = alpha;
	}

	@Override
	public RGB get(int x, int y) {
		if(base1.get(x,y) != null && base2.get(x,y) != null)
			return RGB.mix(base1.get(x,y),base2.get(x,y),alpha);
		else if(base1.get(x, y) != null)
			return base1.get(x, y);
		else if(base2.get(x, y) != null)
			return base2.get(x, y);
		return RGB.BLACK;
	}	
}
