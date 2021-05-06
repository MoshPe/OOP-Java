package StringSet;

public class StringSet {
	private String[] arr;
	private int num;

	public StringSet(int size) {
		arr = new String[size];
		
	}

	public void add(String s) throws StringSetFullException {
		if(s ==null)
			throw new NullPointerException();
		if(num == arr.length)
			throw new StringSetFullException();
		if(!contains(s))
			arr[num++] = s;
	}

	public boolean contains(String s) {
		if(s ==null)
			throw new NullPointerException();
		for (int i = 0; i < num; i++)
			if (arr[i].equals(s))
				return true;
		return false;
	}
}
