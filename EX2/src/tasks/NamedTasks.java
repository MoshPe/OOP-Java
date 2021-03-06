package tasks;

public class NamedTasks extends Tasks {
	private String[] names;

	public NamedTasks(String[] names) {
		super(names.length);
		this.names = names;
	}
	/* By using the strings index the function also creates a Neighbor matrix
	 * to save the dependencies 
	 */
	public boolean dependsOn(String task1, String task2) {
		int indexTask1 = 0;
		int indexTask2 = 0;
		boolean isExistTask1 = false;
		boolean isExistTask2 = false;
		/* checking if the given tasks exist in the 
		 * given String array from allocating the class
		 */
		for (int i = 0; i < names.length; i++) {
			if (task1.equals(names[i])) {
				isExistTask1 = true;
				indexTask1 = i;
			}
			if (task2.equals(names[i])) {
				isExistTask2 = true;
				indexTask2 = i;
			}
		}
		if (isExistTask1 && isExistTask2) {
			super.dependsOn(indexTask1, indexTask2);
			return true;
		}
		return false;
	}
	/*The function gets the array of indexes from the inherited function order
	 * and use the array to place to Strings in the right place
	 */
	public String[] nameOrder() {
		String[] returnNames = new String[names.length];
		int[] namesIndexes = super.order();
		if(namesIndexes == null)
			return null;
		for(int i = 0; i < names.length ; i++)
			returnNames[i] = names[namesIndexes[i]];
		return returnNames;
	}
}
