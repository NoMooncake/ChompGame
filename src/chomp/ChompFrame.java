/**
 * -----------------------------------------------------------------------------
 * File Name: ChompFrame.java
 * Project: ChompGame
 * <p>
 * Author: Yue Wu
 * Date: 2025/11/15
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */


package chomp;

import javax.swing.*;
import java.awt.*;

/**
 * Main application window for the Chomp game.
 * It arranges the {@link InfoPanel} at the top and the
 * {@link GamePanel} in the center.
 */
public class ChompFrame extends JFrame {

    private final InfoPanel infoPanel;
    private final GamePanel gamePanel;

    public ChompFrame(int rows, int cols) {
        super("Chomp Game");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        infoPanel = new InfoPanel();
        gamePanel = new GamePanel(rows, cols);

        add(infoPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    public InfoPanel getInfoPanel() {
        return infoPanel;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }
}
