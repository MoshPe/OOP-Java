package library;
/*
 * Position: save the author's name and birth year
 * Methods: return author's name
 * 			return author's birthYear
 * 			return author's age
 */
public class Author {
	private int birthYear;
	private String name;
	
	public Author(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
	}
	
	public String getName() { return name; }

	public int getBirthYear() { return birthYear; }
	
	public int getAge(int thisYear) { return thisYear - birthYear; }
	
	public String toString() {
		return name+"("+birthYear+")";
	}
}
