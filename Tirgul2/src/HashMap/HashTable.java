package HashMap;

public class HashTable {
	protected String[] table;
	int tableSize;

	public HashTable (int size) {
		table = new String[size];
		this.tableSize = size;
	}
	protected int indexOf(String s) {
		int i = Math.abs(s.hashCode()) % tableSize;
		while(table[i] != null) {
			if(s.equals(table[i]))
				return i;
			i++;
			if(i == tableSize)
				i=0;
		}
		return i;
	}
	
	public void add(String s) {
		table[indexOf(s)] = s;
	}
	
	public boolean contains(String s) {
		return table[indexOf(s)] != null;
	}
}
