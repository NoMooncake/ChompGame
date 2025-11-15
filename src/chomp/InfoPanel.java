/**
 * -----------------------------------------------------------------------------
 * File Name: InfoPanel.java
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
import java.awt.*;

/**
 * A simple info bar displayed at the top of the window.
 * It shows messages such as the current player or the winner.
 */
public class InfoPanel extends JPanel {

    private final JLabel infoLabel;

    public InfoPanel() {
        this.infoLabel = new JLabel("Welcome to Chomp!");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(infoLabel);
    }

    /**
     * Updates the message shown in the info bar.
     */
    public void setInfoText(String text) {
        infoLabel.setText(text);
    }
}
