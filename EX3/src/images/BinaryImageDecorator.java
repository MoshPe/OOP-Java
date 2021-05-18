package images;

public abstract class BinaryImageDecorator implements Image {
	private Image base1, base2;
	
	public BinaryImageDecorator(Image base1, Image base2) {
		this.base1 = base1;
		this.base2 = base2;
	}
	@Override
	public int getWidth() {
		return base1.getWidth() > base2.getWidth()?base1.getWidth() : base2.getWidth();
				
	}
	@Override
	public int getHeight() {
		return base1.getHeight() > base2.getHeight()?base1.getHeight() : base2.getHeight();
	}
	
	@Override
	public abstract RGB get(int x, int y);
	
}