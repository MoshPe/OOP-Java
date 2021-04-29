package images;

public class Mix extends BinaryImageDecorator{
	private Image base1, base2;
	double alpha;
	
	public Mix(Image base1, Image base2, double alpha) {
		super(base1.getWidth() > base2.getWidth()?base1.getWidth() : base2.getWidth(),
				base1.getHeight() > base2.getHeight()?base1.getHeight() : base2.getHeight());
		this.base1 = base1;
		this.base2 = base2;
		this.alpha = alpha;
	}

	@Override
	public RGB get(int x, int y) {
		if(base1.get(x,y) != null && base2.get(x,y) != null )
			return RGB.mix(base1.get(x,y),base2.get(x,y),alpha);
		else if(base1.get(x, y) != null)
			return base1.get(x, y);
		else if(base2.get(x, y) != null)
			return base2.get(x, y);
		return RGB.BLACK;
	}
	/*
	public static void main(String[] argc) {
		Image i1 = new Gradient(100, 150, RGB.RED, 
				RGB.WHITE);
				Image i2 = new Gradient(200, 100, RGB.BLUE, 
				RGB.GREEN);
				Image i = new Mix(i1,  i2, 0.7);
				Displayer.display(i);
	}
	*/
}