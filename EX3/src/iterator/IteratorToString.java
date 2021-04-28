package iterator;

public class IteratorToString {

	public static String toString(MyIterator it) {
		StringBuilder returnString = new StringBuilder();
		returnString.append("[ ");
		while(it.hasNext()) 
			returnString.append(it.next() + " ");
		returnString.append(']');
		return returnString.toString();
	}
	
	public static void main(String[] argc) {
		System.out.println(IteratorToString.toString(new Fibonacci(13)));		
	}
}
