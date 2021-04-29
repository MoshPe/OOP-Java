package images;

public class ItalyImage implements Image {
	public int getWidth() { return 600; }
	public int getHeight() { return 300; }
	public RGB get(int x, int y) {
		return RGB.mix(RGB.RED, RGB.WHITE,0.3);
	}
	/*
	 public static void main(String[] args) {
		Displayer.display(new ItalyImage());
	}
	 */
	
}

