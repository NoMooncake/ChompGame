/**
 * -----------------------------------------------------------------------------
 * File Name: Player.java
 * Project: ChompGame
 * <p>
 * Author: Yue Wu
 * Date: 2025/11/15
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */


package chomp;

/**
 * Simple player model that stores only a name.
 */
public class Player {
    private final String name;

    public Player(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Player name cannot be empty");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }
}