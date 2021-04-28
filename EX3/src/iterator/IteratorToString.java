package iterator;

public class IteratorToString {

	public static String toString(MyIterator it) {
		StringBuilder returnString = new StringBuilder();
		returnString.append("[");
		while(it.hasNext()) 
			returnString.append(it.next() + " ");
		returnString.deleteCharAt(returnString.length()-1);
		returnString.append(']');
		return returnString.toString();
	}
}
