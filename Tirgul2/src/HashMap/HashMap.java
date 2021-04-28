package HashMap;

public class HashMap extends HashTable {
	private String[] values;
	int valuesSize;
	
	public HashMap(int size) {
		super(size);
		this.valuesSize = size;
		values = new String[valuesSize];
	}
	
	public void put(String key, String value) {
		add(key);
		values[indexOf(key)] = value;
	}
	
	public String get(String key) {
		return values[indexOf(key)];
	}
}
