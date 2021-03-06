package tasks;

/*
 * Position: Save the tasks given and output the correct tasks order by dependencies
 * 	Methods: The class uses the Neighbor matrix method for better organizing the dependencies 
 * 			 and then output an array with the correct tasks order.
 * 			 adding a new given road to the roads array which are connected to the current city 			 
 */

public class Tasks {
	private int task[][];
	private int taskSize;

	public Tasks(int num) {
		task = new int[num][num];
		taskSize = num;
	}
	//returning true if the tasks given are valid
	public boolean dependsOn(int task1, int task2) {

		if (task1 >= taskSize || task1 < 0 || task2 >= taskSize || task2 < 0)
			return false;
		//setting that task1 is depending on task2
		task[task2][task1] = 1;
		return true;
	}
	//Using the Neighbor matrix to get the right order onto an array
	public int[] order() {
		int countIndependencies = 0;
		boolean isIndependent = false;
		int j, i, k;
		int returnArrSize = 0;
		int returnArr[] = new int[taskSize];
		resetReturnArr(returnArr);
		for (k = 0; k < taskSize; k++) {
			//going thorough the matrix to find the Independent task
			for (i = 0; i < taskSize; i++) {
				{
					for (j = 0; j < taskSize; j++) {
						if (task[j][i] == 0)
							countIndependencies++;
					}
					if (countIndependencies == taskSize && !isExist(returnArr, i)) {
						returnArr[returnArrSize++] = i;
						isIndependent = true;
						resetRow(task, i);
						/* to break out of the second loop if we found a task that is Independent
						 * and now we want to start the Independent task search from
						 * the start 
						 */
						i = taskSize;
					}
					countIndependencies = 0;
				}
			}
			/* Return null if we haven't found an Independent task in the matrix which indicates
			 * on a circle
			 */
			if (isIndependent == false)
				return null;
			else if (returnArrSize == taskSize)
				return returnArr;
			isIndependent = false;
		}
		return returnArr;
	}
	//checking if a given task is exist in the array
	private boolean isExist(int arr[], int isIn) {
		for (int i = 0; i < arr.length; i++)
			if (isIn == arr[i])
				return true;
		return false;
	}
	/* after printing out a task the function resets all the tasks
	 * that dependent on it
	 */
	private void resetRow(int arr[][], int rowToReset) {
		for (int i = 0; i < taskSize; i++)
			task[rowToReset][i] = 0;
	}
	
	//reseting to -1 instead of 0 to avoid a case with dependencies with 0 
	private void resetReturnArr(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			arr[i] = -1;
	}
}
