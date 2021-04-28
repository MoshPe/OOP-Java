package cards;
		// class that represent deck of cards
public class Deck {
	private int numCards; //number of current cards in the deck
	private Card[] cards;
				// Constructor that gets number and make deck with number * (4 suits)  
	public Deck(int num) {
		this.numCards = num * 4;
		this.cards = new Card[numCards]; // 
			for(int i = 0 ; i < numCards ; i++)
					cards[i] = new Card(i/4,i%4); // card number is i/4, card suit is i modulo 4
	}
				// Constructor that make a deck by taking card after card from the "from" deck (starting from the last card).
				// Total takes num cards (or in the size of "from" deck, the minimal amongst them)
	public Deck(Deck from, int num) {
		numCards = (from.getNumCards() > num) ? num : from.getNumCards(); // Check which one is smaller
		cards = new Card[this.numCards];
		for(int i = 0 ; i < numCards ; i++)
			 cards[i] = from.takeOne();	// Take "numCards" cards from "from" deck and add it to the new deck
	}
				// Constructor that make a deck by taking card after card from the first and second deck (starting from first last card then the second last card).
				// Total make deck of both decks 	
	 public Deck(Deck first, Deck second) {
		
		 numCards=first.numCards + second.numCards; // The new deck is in the size of both first and second deck
		cards=new Card[numCards];
		int i=0;
			while(i<numCards)			// while we didnt run out of cards
			{
				if(first.numCards>0) {		// if first deck isn't empty, take card and promote i
					cards[i]=first.takeOne();
					i++;
				}
				if(second.numCards>0) {		// if second deck isn't empty, take card and promote i
					this.cards[i]=second.takeOne();
					i++;
				}
			}
		}
						// return the current number of cards in the deck
		public int getNumCards() {
			return numCards;
		}
						// take one card from the end of the deck and return it
		public Card takeOne() {
			if(numCards == 0) return null;
			Card returnLastCard = cards[numCards - 1];
			cards[numCards - 1] = null;
			numCards--;
			return returnLastCard;
		}
						// return string of the cards in the deck
	public String toString() {
		String returnString = "[";
		for(int i = 0 ; i < numCards - 1 ; i++)
			returnString += cards[i].toString() + ", ";
		return  returnString + cards[numCards - 1] +"]";	
	}
					// Use bubble sort to sort the deck
	public void sort() { 
	    Card temp;  
	    for(int i = 0; i < numCards; i++){  
	    	for(int j = 1; j < (numCards-i); j++){  
	    			if(cards[j-1].compareTo(cards[j]) > 0){  
	                    //swap elements  
	    				temp = cards[j-1];  
	    				cards[j-1] = cards[j];  
	    				cards[j] = temp;  
	                  }         
	             }  
	       }  
	  } 
}