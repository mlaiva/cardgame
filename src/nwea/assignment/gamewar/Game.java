/* Since a game could conceivably go on forever, we restrict a game of War to at most 1000 turns.

Game is described as a sequence of steps.
1. Create a deck of cards.
2.Shuffle the deck of cards.
3. Create two players named Player 1 and Player 2.
4. Deal all of the cards to the two players.
5. Manage the turns, stopping when one player has insufficient cards to continue or after 100 turns.
	5.1 Ensure that both players have at least one card.Otherwise stop the game.
	5.2 Have each player produce one card and compare the two cards.
	5.3 If one card is higher in rank, give the cards to the player with the higher card and end the turn.
	5.4 If the cards are of the same rank, we have a war.
		5.4.1 Check that each player has enough cards to continue. Otherwise end the game.
		5.4.2 Each player produces a number of cards equal to the rank of cards that caused the tie.
		5.4.3 If the last cards played are of different rank, give all the cards played in this turn to the winning player and end the turn.
		5.4.4 If the last cards played are of equal rank, go back to step 5.4.1.
*/


package nwea.assignment.gamewar;

public class Game {
	public void play() {
		CardDeck cd = new CardDeck();
		cd.shuffle();
		p1 = new Player("Player 1");
		p2 = new Player("Player 2");

		while (cd.getSize() >= 2) {
			p1.collectCard(cd.deal());
			p2.collectCard(cd.deal());
		}
		p1.useWonPile();
		p2.useWonPile();
		Pile down = new Pile(); // Pile for cards in a war
		loop: for (int t = 1; t <= 1000; t++) {
			if (!enoughCards(1))
				break loop;
			Card c1 = p1.playCard();
			Card c2 = p2.playCard();
			System.out.println("\nTurn " + t + ": ");
			System.out.print(p1.getName() + ": " + c1 + " ");
			System.out.print(p2.getName() + ": " + c2 + " ");
			if (c1.compareTo(c2) > 0) {
				p1.collectCard(c1);
				p1.collectCard(c2);
			} else if (c1.compareTo(c2) < 0) {
				p2.collectCard(c1);
				p2.collectCard(c2);
			} else // War
			{
				down.clear();
				down.addCard(c1);
				down.addCard(c2);
				boolean done = false;
				do {
					int num = c1.getRank();
					if (!enoughCards(num))
						break loop;
					System.out.print("\nWar! Players put down ");
					System.out.println(num + " card(s).");
					for (int m = 1; m <= num; m++) {
						c1 = p1.playCard();
						c2 = p2.playCard();
						down.addCard(c1);
						down.addCard(c2);
					}
					System.out.print(p1.getName() + ": " + c1 + " ");
					System.out.print(p2.getName() + ": " + c2 + " ");
					if (c1.compareTo(c2) > 0) {
						p1.collectCards(down);
						done = true;
					} else if (c1.compareTo(c2) < 0) {
						p2.collectCards(down);
						done = true;
					}
				} while (!done);
			} // end of for t=1 to 100
			System.out.println(p1.numCards() + " to " + p2.numCards());
		}
	}

	boolean enoughCards(int n) {
		if (p1.numCards() < n || p2.numCards() < n)
			return false;
		return true;
	}

	public Player getWinner() {
		if (p1.numCards() > p2.numCards())
			return p1;
		else if (p2.numCards() > p1.numCards())
			return p2;
		else
			return null;
	}

	private Player p1, p2;
}