package images;

public class Superpose extends BinaryImageDecorator{
	private Image base1, base2;
	
	public Superpose(Image base1, Image base2) {
		super(base1, base2);
		this.base1 = base1;
		this.base2 = base2;
	}

	@Override
	public RGB get(int x, int y) {
		if(base1.get(x,y) != null && base2.get(x,y) != null )
			return RGB.superpose(base1.get(x,y),base2.get(x,y));
		else if(base1.get(x, y) != null)
			return base1.get(x, y);
		else if(base2.get(x, y) != null)
			return base2.get(x, y);
		return RGB.BLACK;
	}
	

}
