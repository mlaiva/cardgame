/* A Card object is defined by its value (or rank) and its suit.

We represent the value using the integers from 1 to 13. */

package nwea.assignment.gamewar;

class Card implements Comparable {
	Card(int r, int s) {
		rank = r;
		suit = s;
	}

	int getRank() {
		return rank;
	}

	int getSuit() {
		return suit;
	}

	public int compareTo(Object ob) {
		Card other = (Card) ob;
		int thisRank = this.getRank();
		int otherRank = other.getRank();
		if (thisRank == 1)
			thisRank = 14; // make aces high
		if (otherRank == 1)
			otherRank = 14;
		return thisRank - otherRank;
	}

	public boolean equals(Object ob) {
		if (ob instanceof Card) {
			Card other = (Card) ob;

			return rank == other.rank && suit == other.suit;
		} else
			return false;
	}

	public String toString() {
		String val;
		String[] suitList = { "", "Clubs", "Diamonds", "Hearts", "Spades" };
		if (rank == 1)
			val = "Ace";
		else if (rank == 11)
			val = "Jack";
		else if (rank == 12)
			val = "Queen";
		else if (rank == 13)
			val = "King";
		else
			val = String.valueOf(rank); // int to String
		String s = val + " of " + suitList[suit];
		for (int k = s.length() + 1; k <= 17; k++)
			s = s + " ";
		return s;
	}

	private int rank;
	private int suit;
}