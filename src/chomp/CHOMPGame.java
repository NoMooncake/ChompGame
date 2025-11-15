/**
 * -----------------------------------------------------------------------------
 * File Name: CHOMPGame.java
 * Project: ChompGame
 * <p>
 * Author: Yue Wu
 * Date: 2025/11/15
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */


package chomp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Concrete implementation of the Chomp game.
 * This class extends the generic {@link Game} skeleton and also acts
 * as the controller for the Swing UI by implementing {@link ActionListener}.
 *
 * <p>
 * DESIGN NOTE: I keep the poison cell at (0,0) (top-left) to align
 * with Swing's 0-based row/column indexing, which is a slight deviation
 * from the original description but simplifies coordinate handling.
 */
public class CHOMPGame extends Game implements ActionListener {

    private final Board board;
    private final Display display;
    private Player winner;

    public CHOMPGame(int rows, int cols, String player1Name, String player2Name) {
        super(new Player(player1Name), new Player(player2Name));
        this.board = new Board(rows, cols);
        this.display = new Display(rows, cols);
        this.winner = null;

        display.setController(this);
        display.refreshBoard(board);
        display.updateInfo("Current player: " + getCurrentPlayer().getName());
        display.show();
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public void playTurn(int row, int col) {
        if (isGameOver()) {
            return;
        }

        if (!board.isCellAvailable(row, col)) {
            JOptionPane.showMessageDialog(
                    display.getFrame(),
                    "This cell has already been eaten!",
                    "Invalid Move",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        board.makeMove(row, col);

        if (board.isPoisonEaten()) {
            winner = players[1 - currentPlayerIndex];
        } else {
            switchPlayer();
        }
    }

    @Override
    public boolean isGameOver() {
        return board.isPoisonEaten();
    }

    @Override
    public Player getWinner() {
        return winner;
    }

    /**
     * Handles button click events from the UI.
     * Decodes the "row,col" action command, delegates to {@link #playTurn(int, int)},
     * and then refreshes the display.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!(e.getSource() instanceof JButton)) {
            return;
        }

        String cmd = e.getActionCommand();
        String[] parts = cmd.split(",");
        int row = Integer.parseInt(parts[0]);
        int col = Integer.parseInt(parts[1]);

        playTurn(row, col);

        display.refreshBoard(board);

        if (isGameOver()) {
            display.updateInfo("Game over! Winner: " + getWinner().getName());
        } else {
            display.updateInfo("Current player: " + getCurrentPlayer().getName());
        }
    }
}
