/**
 * -----------------------------------------------------------------------------
 * File Name: Main.java
 * Project: ChompGame
 * Description:
 * [Add brief description here]
 * <p>
 * Author: Yue Wu
 * Date: 2025/11/15
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */


package chomp;

/**
 * Simple console-based test harness for the Chomp game logic.
 * This is independent from the Swing GUI and can be used to
 * verify the {@link Board} behavior.
 */
public class Main {
    public static void main(String[] args) {
        CHOMPGame game = new CHOMPGame(4, 6, "Player 1", "Player 2");

        // Example: play two moves purely for debugging.
        game.playTurn(1, 2);
        game.playTurn(0, 1);

        printBoard(game.getBoard());

        System.out.println("Game over? " + game.isGameOver());
        if (game.isGameOver()) {
            System.out.println("Winner: " + game.getWinner().getName());
        } else {
            System.out.println("Current player: " + game.getCurrentPlayer().getName());
        }
    }

    private static void printBoard(Board board) {
        System.out.println("Board state (X = eaten, O = available):");
        for (int r = 0; r < board.getRows(); r++) {
            for (int c = 0; c < board.getCols(); c++) {
                System.out.print(board.getCell(r, c).isEaten() ? "X " : "O ");
            }
            System.out.println();
        }
    }
}
