package library;
/*
 * Position: save the book's name and its author name
 * 			 and the author's birth Year.
 * Methods:	 return the book's title
 * 			 return the book's author
 * 			 return the book's author birth year			 
 */
public class Book {
	private String title,authorName;
	private int authorBirthYear;
	
	public Book(String title,Author auth) {
		this.title = title;
		this.authorName = auth.getName();
		this.authorBirthYear = auth.getBirthYear();
	}

	public String getTitle() { return title; }
	
	public String getAuthorName() { return authorName; }
	
	public int getAuthorBirthYear() { return authorBirthYear; }
	
	public String toString(){
		return title+" written by "+authorName+"("+authorBirthYear+")";
	}
}
