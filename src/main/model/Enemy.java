package model;

import java.util.*;

import ui.Main;

// Represents an Enemy GameObject. The enemy in the game.
public class Enemy extends GameObject {
    // The Player in the game
    private Player player;
    // Counter for moving every so often
    private int moveCounter = 0;

    // Constructs a enemy at random position
    // Requires: player is not null
    // Effects: this updated with position posX and posY and this.player = player
    public Enemy(int posX, int posY, Player player) {
        super(posX, posY);
        this.player = player;
    }

    // Move enemy
    // Modifies: this
    // Effects: Move enemy by 1 in random direction if player is not there
    public void move() {
        Random random = new Random();
        int moveX = x1 + random.nextInt(3) - 1;
        int moveY = y1 + random.nextInt(3) - 1;
        x1 = clamp(moveX, 0, Main.GAME_WIDTH - 1);
        y1 = clamp(moveY, 0, Main.GAME_HEIGHT - 1);
        

    }


    // Clamps value so it does not exceed min or max
    // Requires: min <= max
    // Effects: Returns value if min <= value <= max; returns max if value > max; returns min if value < min
    public int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }


    // Update the enemy every game tick
    // Modifies: this
    // Effects: Move the enemy every 31 ticks
    public void update() {
        moveCounter++;
        if (moveCounter == 31) {
            move();
            moveCounter = 0;
        }
    }
}
