package cards;
		// Class that represent single card 
public class Card {
	private int num;
	private int suit;

		// Constructor that fill number of card and the suit (received when the card made)
	public Card(int num, int suit){
		this.num = num;
		this.suit = suit;
	}
		//return the number of the card
	public int getNum() { return this.num; }
		//return the suit of the card
	public int getSuit() { return this.suit; }
		
		//return string with the number and the suit of the card
	public String toString() {
		String []suitLetter = {"C","D","H","S"};
		return num+suitLetter[suit]; 
	}
		//return: 1 if the card is greater then the other card,
		// -1 if the other card is greater then the card,
		// 0 if they equal
	public int compareTo(Card other) {
		int numDiff = num - other.getNum(); 
		int suitDiff = suit - other.getSuit(); 
		if(numDiff != 0) // if both numbers of the card are not equal
			return numDiff; 
		return suitDiff; // if the cards numbers are equal, return the diffrence of the suits		
	}				
}
