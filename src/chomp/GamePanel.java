/**
 * -----------------------------------------------------------------------------
 * File Name: GamePanel.java
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
import java.awt.event.ActionListener;


/**
 * Panel that displays a grid of buttons representing the Chomp board.
 * The panel itself does not implement any game logic; it only exposes
 * an API to attach a controller and to refresh its appearance from
 * a {@link Board} instance.
 */
public class GamePanel extends JPanel {

    private final int rows;
    private final int cols;
    private final JButton[][] buttons;

    public GamePanel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.buttons = new JButton[rows][cols];

        setLayout(new GridLayout(rows, cols));
        initButtons();
    }

    /**
     * Initializes the button grid.
     */
    private void initButtons() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                JButton button = new JButton(" "); // 先不显示文字
                button.setFocusPainted(false);
                button.setOpaque(true);       // 方便改背景色
                button.setBorderPainted(true);

                buttons[r][c] = button;
                add(button);
            }
        }
    }

    /**
     * Attaches a controller to every button.
     * The button's action command is set to "row,col" so the controller
     * can decode which cell was clicked.
     *
     * @param listener the shared {@link ActionListener} to handle clicks
     */
    public void setCellListener(ActionListener listener) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                JButton button = buttons[r][c];
                button.setActionCommand(r + "," + c);
                for (ActionListener old : button.getActionListeners()) {
                    button.removeActionListener(old);
                }
                button.addActionListener(listener);
            }
        }
    }

    /**
     * Updates the visual state of the button grid based on the given board.
     *
     * @param board the board whose state should be reflected in the UI
     */
    public void refreshFromBoard(Board board) {
        for (int r = 0; r < board.getRows(); r++) {
            for (int c = 0; c < board.getCols(); c++) {
                JButton btn = buttons[r][c];
                Cell cell = board.getCell(r, c);

                if (cell.isEaten()) {
                    btn.setEnabled(false);
                    btn.setBackground(Color.LIGHT_GRAY);
                } else {
                    btn.setEnabled(true);
                    if (cell.isPoison()) {
                        btn.setBackground(Color.RED);
                    } else {
                        btn.setBackground(new Color(205, 133, 63)); // 巧克力色
                    }
                }
            }
        }
    }

    public JButton getButton(int row, int col) {
        return buttons[row][col];
    }
}