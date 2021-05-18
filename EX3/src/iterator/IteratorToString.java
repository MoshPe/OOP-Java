package iterator;

//this class return representation of Iterator in String
public class IteratorToString {

	public static String toString(MyIterator it) {
		StringBuilder returnString= new StringBuilder();
		returnString.append('[');
		while (it.hasNext())
			returnString.append(it.next() + " ");
		// replace the last space with ']'
		if (returnString.length() > 1)
			returnString.setCharAt(returnString.length() - 1, ']');
		else // in case we don't have any element in str
			returnString.append(']');
		return returnString.toString();
	}
}
