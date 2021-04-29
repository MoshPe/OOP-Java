package images;

public class TwoColorImage extends BaseImage{
	private RGB zero, one;
	private TwoDFunc func;
	private int width,height;
	public TwoColorImage(int width, int height, RGB zero, RGB one, TwoDFunc func){
		super(width, height);
		this.zero = zero;
		this.one = one;
		this.func = func;
		this.height = height;
		this.width= width;
		
	}
	@Override
	public RGB get(int x, int y) {
		double temp = func.f((double)x/width,(double)y/height);
		if(temp <= 0)
			return zero;
		else if(temp >= 1)
			return one;
		else
			return RGB.mix(one,zero, temp);
	}
	/*
	public static void main(String[] argc) {
		Image i = new TwoColorImage(200, 100, RGB.BLACK, 
				RGB.RED, new Func1());
				Displayer.display(i);

	}
	*/
}