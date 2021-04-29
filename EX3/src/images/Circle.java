package images;

import java.awt.geom.Point2D;

public class Circle extends BaseImage{
	private int centerY, centerX, radius;
	private RGB center, outside;
	
	public Circle(int width, int height, int centerX, int centerY, int radius, RGB center, RGB outside) {
		super(width,height);
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
		this.center = center;
		this.outside = outside;
	}
	public Circle(int size, int radius, RGB center, RGB outside) {
		super(size,size);
		centerX = size/2;
		centerY = size/2;
		this.radius = radius;
		this.center = center;
		this.outside = outside;
	}
	
	@Override
	public RGB get(int x, int y) {
		if(x > getWidth() || y > getHeight())
			return null;
		double test = Point2D.distance(x, y, centerX, centerY) / (double)radius;
		if(test < 1)
			return RGB.mix(outside, center,test);
		else
			return outside;
	}
	/*
	public static void main(String[] argc) {
		Image i = new Circle(120, 60, RGB.WHITE, RGB.BLACK);
		//Image i = new Circle(600, 300, 70, 70, 90, RGB.BLUE, new RGB(0.5, 0, 0.5));
				Displayer.display(i);
	}
	*/
}
