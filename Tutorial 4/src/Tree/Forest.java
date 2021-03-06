package Tree;


public class Forest {
	private Tree[] trees;
	
	
	public Forest(Tree[] trees) {
		this.trees = trees;
	}
	
	public int totalCost(int years) {
		int sum = 0;
		for (Tree tree : trees) 
			sum += tree.totalCost(years);
		return sum;
		}

	@Override 
	public String toString() {
		StringBuilder returnTreesName = new StringBuilder();
		for (Tree tree : trees) {
			returnTreesName.append(tree.getName());
			returnTreesName.append(" ");
		}
		returnTreesName.deleteCharAt(returnTreesName.length() - 1);
		return returnTreesName.toString();
	}

}
