/**
 * -----------------------------------------------------------------------------
 * File Name: Game.java
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
 * Generic two-player, turn-based game skeleton.
 * Uses a Template Method style where concrete subclasses specify
 * how a turn is played and how game over / winner are determined.
 */
public abstract class Game {

    protected final Player[] players;
    protected int currentPlayerIndex = 0;

    protected Game(Player player1, Player player2) {
        this.players = new Player[] { player1, player2 };
    }

    /**
     * Returns the player whose turn it currently is.
     */
    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    /**
     * Switches to the other player.
     */
    protected void switchPlayer() {
        currentPlayerIndex = 1 - currentPlayerIndex;
    }

    /**
     * Plays one turn of the game using a move at (row, col).
     *
     * @param row the row index of the move
     * @param col the column index of the move
     */
    public abstract void playTurn(int row, int col);

    /**
     * Returns true if the game has reached a terminal state.
     */
    public abstract boolean isGameOver();

    /**
     * Returns the winner if there is one, or {@code null} if the game
     * is not over yet or there is no winner.
     */
    public abstract Player getWinner();
}
