package library;

/*
 * Position: saves an array of books and the amount of books 
 * 			 in the library
 * 	Methods: and the author's birth Year.
 * 			 setting a new book in the library
 * 			 return a book reference by the book index in the array
 * 			 return the book's author birth year			 
 */
public class Library {
	private Book[] a;
	private int numOfBooksPossible;

	public Library(int size) {
		this.a = new Book[size];
		numOfBooksPossible = size;
	}

	public void setBook(int bookNum, String title, Author auth) {
		if (bookNum >= 0 && bookNum < numOfBooksPossible && a[bookNum] == null)
			a[bookNum] = new Book(title, auth);
	}

	public Book getBook(int bookNum) {
		if (bookNum >= 0 && bookNum < numOfBooksPossible && a[bookNum] != null)
			return a[bookNum];
		return null;
	}
}
