/**
 * -----------------------------------------------------------------------------
 * File Name: Board.java
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
 * Model of the Chomp board.
 * Holds a 2D grid of {@link Cell} objects and implements the core
 * Chomp move logic: choosing a cell eats that cell and all cells
 * to its bottom-right.
 */
public class Board {

    private final int rows;
    private final int cols;
    private final Cell[][] grid;

    public Board(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Board size must be positive");
        }
        this.rows = rows;
        this.cols = cols;
        this.grid = new Cell[rows][cols];
        initialize();
    }

    /**
     * Initializes all cells. (0,0) is the poison cell.
     */
    private void initialize() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                boolean poison = (r == 0 && c == 0); // top-left as poison
                grid[r][c] = new Cell(r, c, poison);
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Cell getCell(int row, int col) {
        checkBounds(row, col);
        return grid[row][col];
    }

    /**
     * Returns {@code true} if this cell has not been eaten yet.
     */
    public boolean isCellAvailable(int row, int col) {
        checkBounds(row, col);
        return !grid[row][col].isEaten();
    }

    /**
     * Performs a Chomp move:
     * eats the chosen cell and all cells with r >= row and c >= col.
     *
     * @throws IllegalArgumentException if the chosen cell is already eaten
     */
    public void makeMove(int row, int col) {
        checkBounds(row, col);
        if (!isCellAvailable(row, col)) {
            throw new IllegalArgumentException("Cell is already eaten");
        }

        for (int r = row; r < rows; r++) {
            for (int c = col; c < cols; c++) {
                if (!grid[r][c].isEaten()) {
                    grid[r][c].eat();
                }
            }
        }
    }

    /**
     * Returns {@code true} if the poison cell at (0,0) has been eaten.
     */
    public boolean isPoisonEaten() {
        return grid[0][0].isEaten();
    }

    private void checkBounds(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException("Invalid cell: (" + row + "," + col + ")");
        }
    }
}
