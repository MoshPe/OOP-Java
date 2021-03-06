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
		//checking if the given indexes are legal
		if(x > getWidth() || y > getHeight())
			return null;
		//calculate the distance from the middle coordinates
		double distanceFromCenter = Point2D.distance(x, y, centerX, centerY) / radius;
		if(distanceFromCenter < 1)
			return RGB.mix(outside, center,distanceFromCenter);
		else
			return outside;
	}
}
