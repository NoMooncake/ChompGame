/**
 * -----------------------------------------------------------------------------
 * File Name: Display.java
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

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Simple facade over the GUI components.
 * It wires together the {@link ChompFrame}, {@link GamePanel},
 * and {@link InfoPanel}, and exposes high-level operations to
 * update the view from the model.
 *
 * <p>
 * DESIGN NOTE: The original design wired GUI components directly
 * in the game/controller class. Here I introduce a Display facade
 * to keep the controller smaller and to better separate MVC concerns.
 */
public class Display {

    private final ChompFrame frame;
    private final GamePanel gamePanel;
    private final InfoPanel infoPanel;

    public Display(int rows, int cols) {
        this.frame = new ChompFrame(rows, cols);
        this.gamePanel = frame.getGamePanel();
        this.infoPanel = frame.getInfoPanel();
    }

    /**
     * Makes the main window visible.
     */
    public void show() {
        frame.setVisible(true);
    }

    /**
     * Attaches the given controller as an {@link ActionListener}
     * to all game board buttons.
     */
    public void setController(ActionListener listener) {
        gamePanel.setCellListener(listener);
    }

    /**
     * Refreshes the game board UI based on the given {@link Board} state.
     */
    public void refreshBoard(Board board) {
        gamePanel.refreshFromBoard(board);
    }

    /**
     * Updates the info text shown in the top panel.
     */
    public void updateInfo(String text) {
        infoPanel.setInfoText(text);
    }

    /**
     * Returns the underlying {@link JFrame}, useful for dialogs.
     */
    public JFrame getFrame() {
        return frame;
    }
}
