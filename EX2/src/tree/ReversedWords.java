package tree;

import java.util.Scanner;

//this class demonstrate the use of Node class
public class ReversedWords {

	// this function reverse the given string and return it to the caller
	private static String getReversedString(String s) {
		if (s.length() == 0)
			return null;
		String revString = "";
		for (int i = s.length() - 1; i >= 0; i--)
			revString += s.charAt(i);
		return revString;
	}

	public static int checkReversed() {
		int reversedWordsCount= 0;
		boolean isX = false;
		String getString, reversedString;
		Node stringsTree = new Node();
		Scanner word = new Scanner(System.in);
		//checking if the input is correct
		if(!word.hasNext()) {
			System.out.println("Error: invalid input");
			word.close();
			return -1;
		}
		// while we have next word that don't equal to 'X'
		while (word.hasNext() && !(word.hasNext("X"))) {
			getString = word.next();
			reversedString = new String();
			reversedString = getReversedString(getString);
			// if the reversed string appear in the tree (text), count it.
			if (stringsTree.num(reversedString) != 0)
				reversedWordsCount++;
			// then add it to the tree
			stringsTree.add(getString);
			//checking if there was an X at the end
			if(word.hasNext("X"))
				isX = true;
		}
		word.close();
		return (isX)? reversedWordsCount : -1;
	}
}
