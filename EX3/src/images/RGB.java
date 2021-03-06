package images;

public class RGB {
	private double blue, green, red;
	
	public static final RGB BLACK = new RGB(0);
	public static final RGB WHITE = new RGB(1);
	public static final RGB RED = new RGB(1,0,0);
	public static final RGB GREEN = new RGB(0,1,0);
	public static final RGB BLUE = new RGB(0,0,1);	
	
	public RGB(double red,double green, double blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public RGB(double grey) {
		red = green = blue = grey;
	}

	public double getRed() { return red; }

	public double getBlue() { return blue; }

	public double getGreen() { return green; }

	public RGB invert() { return new RGB(1-red,1-green,1-blue); }
	
	public RGB filter(RGB filter) {
		return new RGB(red * filter.getRed(),green * filter.getGreen(), blue * filter.getBlue());
	}
	
	public static RGB superpose(RGB rgb1, RGB rgb2) {
		double green = rgb1.getGreen() + rgb2.getGreen() > 1 ? 1 : rgb1.getGreen() + rgb2.getGreen();
		double blue = rgb1.getBlue() + rgb2.getBlue() > 1 ? 1 : rgb1.getBlue() + rgb2.getBlue();
		double red = rgb1.getRed() + rgb2.getRed() > 1 ? 1 : rgb1.getRed() + rgb2.getRed();
		return new RGB(red,green,blue);
	}
	
	public static RGB mix(RGB rgb1, RGB rgb2, double alpha) {
		double green = alpha * rgb1.getGreen() + (1-alpha) * rgb2.getGreen();
		double blue = alpha * rgb1.getBlue() + (1-alpha) * rgb2.getBlue();
		double red = alpha * rgb1.getRed() + (1-alpha) * rgb2.getRed();
		return new RGB(red,green,blue);
	}
	@Override
	public String toString() {
		return String.format("<%.4f, %.4f, %.4f>",red,green, blue);
	}
}
