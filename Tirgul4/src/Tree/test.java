package Tree;

import java.util.Arrays;

public class test {
	public static void main(String []args) {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++)
			 arr[i] = arr.length - i;
		Arrays.sort(arr);
		System.out.print(Arrays.toString(arr));
	}
	}

