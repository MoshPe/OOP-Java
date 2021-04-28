package iterator;

public class MyArray implements MyIterator {
	private int[] arr;
	private int index;
	
	public MyArray(int[] x) {
		arr = x;
		index = 0;
	}
	@Override
	public boolean hasNext() {
		return index < arr.length;
	}

	@Override
	public int next() {
		if(!hasNext())
			throw new IndexOutOfBoundsException();
		return arr[index++];
	}
	
	
	/*
	public static void main(String[] argc) {
	int[] x = {2, 4, 6, 1};
	MyIterator it = new MyArray(x);
	while(it.hasNext())
		System.out.print(it.next() + " ");
	}*/
}