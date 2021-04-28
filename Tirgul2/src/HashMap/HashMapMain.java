package HashMap;

public class HashMapMain {

	public static void main(String[] args) {
		HashMap m = new HashMap(100);
		
		m.put("one", "un");
		m.put("two", "dos");
		m.put("three", "tres");
		m.put("four", "quatro");

		System.out.println(m.get("four"));
		System.out.println(m.get("seven"));
	}

}
