/*
 * A Pile object holds an array to contain its cards.

 * Two instance variables indicate the portion of the array that contains the cards belonging to the pile.
    *end is the position into which the next card is added to the pile.
	*front is the position from which the next card will be
	*taken provided front < end.
	*A pile is empty if front has the same value as end
 */

package nwea.assignment.gamewar;

class Pile {
	Pile() {
		pile = new Card[52];
		front = 0;
		end = 0;
	}

	int getSize() {
		return end - front;
	}

	void clear() {
		front = 0;
		end = 0;
	}

	void addCard(Card c) {
		pile[end] = c;
		end++;
	}

	void addCards(Pile p) {
		while (p.getSize() > 0)
			addCard(p.nextCard());
	}

	Card nextCard() {
		if (front == end)
			return null; // should not happen
		Card c = pile[front];
		front++;
		return c;
	}

	private Card[] pile;
	private int front, end; // front ≤ end
}
