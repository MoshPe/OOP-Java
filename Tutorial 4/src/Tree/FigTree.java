package Tree;

public class FigTree extends Tree {
	private static final String FIGG_TREE_NAME = "Fig";
	private static final int MAINTAIN_PER_YEAR = 10;
	
	public FigTree () {
		super(100);
	}
	
	@Override
	public String getName() {
		return FIGG_TREE_NAME;
	}

	@Override
	protected int costAtYear(int year) {
		return MAINTAIN_PER_YEAR;
	}

}
