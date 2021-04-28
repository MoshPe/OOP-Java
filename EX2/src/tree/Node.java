package tree;

//this class is for single node in the tree, with array of pointers to the node childs 
public class Node {
	private int count;
	private Node[] childern;

	public Node() {
		count = 0;
		childern = new Node[26];
	}
	public int num(String s) {
		if (s.length() == 0) // if string length is 0 it means we are in the right node
			return count;
		if (childern[s.charAt(0) - 'a'] != null) // if the next character is exist

			/* go to the next node with the string without this character and do the same
			   thing
			 */
			return childern[s.charAt(0) - 'a'].num(s.substring(1));
		else
			return 0; // if the character don't exist
	}

	public void add(String s) {
		if (s.length() == 0) // if string length is 0 it means we are in the right node
			count++; // we have one more from this string
		else {
			if (childern[s.charAt(0) - 'a'] == null) // if the next character don't exist yet, allocate memory for it
				childern[s.charAt(0) - 'a'] = new Node();
			/* if it exist, go to the next node with the string without this character and
			   do the same thing
			*/
			childern[s.charAt(0) - 'a'].add(s.substring(1));
		}
	}
}
