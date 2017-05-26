/*
If the player has no cards at all, an outcome that should not happen if the game is played correctly, the method

playCard returns null.
If a player finds his or her playing pile is empty, the pile of cards won by that player becomes a new playing pile.
The useWonPile method initializes the playing pile so that its position variables, front and end, will not exceed its
array size, adds the cards from the pile of won cards, and finally initializes (empties) that pile.
 */
package nwea.assignment.gamewar;

public class Player {
	Player(String n) {
		name = n;
		playPile = new Pile();
		wonPile = new Pile();
	}

	Card playCard() {
		if (playPile.getSize() == 0)
			useWonPile();
		if (playPile.getSize() > 0)
			return playPile.nextCard();
		return null;
	}

	public String getName() {
		return name;
	}

	void collectCard(Card c) {
		wonPile.addCard(c);
	}

	void collectCards(Pile p) {
		wonPile.addCards(p);
	}

	void useWonPile() {
		playPile.clear(); // reset front and end to 0
		playPile.addCards(wonPile);
		wonPile.clear(); // reset front and end to 0
	}

	int numCards() {
		return playPile.getSize() + wonPile.getSize();
	}

	private Pile playPile, wonPile;
	private String name;
}
