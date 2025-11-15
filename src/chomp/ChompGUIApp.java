/**
 * -----------------------------------------------------------------------------
 * File Name: ChompGUIApp.java
 * Project: ChompGame
 * <p>
 * Author: Yue Wu
 * Date: 2025/11/15
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */


package chomp;

import javax.swing.*;

/**
 * Entry point for launching the Chomp game with a Swing GUI.
 * <p>
 * DESIGN NOTE: I provide a separate GUI entry point instead of a single
 * Driver class so that the console-based test harness can remain
 * independent for debugging the model.
 */
public class ChompGUIApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CHOMPGame(4, 6, "Player 1", "Player 2");
        });
    }
}