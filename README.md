Card Game Of War

Rules of the Game:

A card deck consists of 52 playing cards, each of which has a numeric value between 1 and 13, called the rank of the card, and one of four suits (clubs, diamonds, hearts, and spades). 

The values 1, 11, 12, and 13 have special names: ace, jack, queen, and king, respectively. To play the game we deal the entire deck of cards to two players. 

Each player has a pile of 26 cards face down on the table. During a turn of the game, the players show the top cards from their piles, and the player with the higher-ranking card wins both of the cards, putting them face up in a pile.

For the purpose of comparison, aces count as highest. If the cards shown by the players have the same rank, each player places the number of cards equal to that rank face down on the table.

The last cards played by each player are turned over and compared. The higher value wins all of the cards that have been played this turn.

If another tie occurs, the process is repeated. 

When a player finishes playing all of the cards in his or her playing pile, the cards won in previous turns are turned over and become a new playing pile. 

If either player cannot complete a turn for lack of cards, the other player wins the game.

The goal of this program is to simulate the playing of a game of War with two players, named Player 1 and Player 2

***************************
Running The Application:

CardGame.jar is runnable jar file; you can run this at your machine by the following command.

Java –jar CardGame.jar
**************************

Since a game could conceivably go on forever, we restrict a game of War to at most 1000 turns.


Game is described as a sequence of steps.
1. Create a deck of cards.
2.Shuffle the deck of cards.
3. Create two players named Player 1 and Player 2.
4. Deal all of the cards to the two players.
5. Manage the turns, stopping when one player has insufficient cards to continue or after 1000 turns.

5.1 Ensure that both players have at least one card. Otherwise stop the game.

5.2 Have each player produce one card and compare the two cards.

5.3 If one card is higher in rank, give the cards to the player with the higher card and end the turn.

5.4 If the cards are of the same rank, we have a war.

5.4.1 Check that each player has enough cards to continue. Otherwise end the game.

5.4.2 Each player produces a number of cards equal to the rank of cards that caused the tie.

5.4.3 If the last cards played are of different rank, give all the cards played in this turn to the winning player and end the turn.

5.4.4 If the last cards played are of equal rank, go back to step 5.4.1.
    
 A Pile object holds an array to contain its cards.
  *Two instance variables indicate the portion of the array that contains the cards belonging to the pile.
    *end is the position into which the next card is added to the pile.
	*front is the position from which the next card will be
	*taken provided front < end.
	*A pile is empty if front has the same value as end
  
A CardDeck object will contain an array of 52 Card objects, which are created by the Card constructor, whose parameters are an integer value and an integer code representing the suit

 * Since the cards will be dealt during the game, we maintain a property (an instance variable) to hold the
   number of cards left in the deck. That number counts down from 52 to 0 as the cards are dealt.
 * The deal method returns cards from the array starting at position 51. Since the method promises to return an object,
   we have it return null if it is called with an empty deck.
 *A CardDeck object responds to a method getSize that returns the number of card left in the deck as it is dealt.


		


