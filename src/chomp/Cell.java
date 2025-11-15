/**
 * -----------------------------------------------------------------------------
 * File Name: Cell.java
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
 * Represents a single chocolate cell in the Chomp board.
 * A cell knows its position, whether it is the poison cell,
 * and whether it has already been eaten.
 */
public class Cell {
    private final int row;
    private final int col;
    private boolean eaten;
    private final boolean poison;

    public Cell(int row, int col, boolean poison) {
        this.row = row;
        this.col = col;
        this.poison = poison;
        this.eaten = false;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isEaten() {
        return eaten;
    }

    public boolean isPoison() {
        return poison;
    }

    /**
     * Marks this cell as eaten.
     */
    public void eat() {
        this.eaten = true;
    }
}
