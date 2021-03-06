package Tree;

public class OrangeTree extends Tree {
	private static final String FIGG_TREE_NAME = "Orange";
	
	public OrangeTree() {
		super(150);
	}
	
	@Override
	public String getName() {
		return FIGG_TREE_NAME;
	}

	@Override
	protected int costAtYear(int year) {
		if(year < 3)
			return 100;
		if(year > 6)
			return -100;
		return 0;
	}
}
