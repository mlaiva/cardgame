/* A CardDeck object will contain an array of 52 Card objects, which are created by the Card constructor,

whose parameters are an integer value and an integer code representing the suit

* Since the cards will be dealt during the game, we maintain a property (an instance variable) to hold the
number of cards left in the deck. That number counts down from 52 to 0 as the cards are dealt.

* The deal method returns cards from the array starting at position 51. Since the method promises to return an object,
we have it return null if it is called with an empty deck.

*A CardDeck object responds to a method getSize that returns the number of card left in the deck as it is dealt.

*/
package nwea.assignment.gamewar;

class CardDeck {
	CardDeck() {
		deck = new Card[52];
		fill();
	}

	void shuffle() {
		for (int next = 0; next < numCards - 1; next++) {
			int r = myRandom(next, numCards - 1);
			Card temp = deck[next];
			deck[next] = deck[r];
			deck[r] = temp;
		}
	}

	Card deal() {
		if (numCards == 0)
			return null;
		numCards--;
		return deck[numCards];
	}

	int getSize() {
		return numCards;
	}

	private void fill() {
		int index = 0;
		for (int r = 1; r <= 13; r++)
			for (int s = 1; s <= 4; s++) {
				deck[index] = new Card(r, s);
				index++;
			}
		numCards = 52;
	}

	private static int myRandom(int low, int high) {
		return (int) ((high + 1 - low) * Math.random() + low);
	}

	private Card[] deck;
	private int numCards;
}
