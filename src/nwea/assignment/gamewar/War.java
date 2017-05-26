/*War class is to instantiate a Game object, call its play method, and report who won the game.*/
package nwea.assignment.gamewar;

public class War {
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
		Player winner = g.getWinner();
		if (winner == null)
			System.out.println("Tie game.");
		else
			System.out.println("\nWinner =" + winner.getName());
	}
}
