package model;

import ui.Main;

// Represents a Player GameObject. The player in the game which will be controlled by the user.
public class Player extends GameObject {
    // Direction the player is facing
    private String facing = "up";

    // Constructs a player at position (2,2)
    // Effects: this updated with facing to be "right"
    public Player() {
        super(2, 2);
        facing = "right";
    }

    // What direction is the player facing
    // Effects: Returns facing
    public String getFacing() {
        return facing;
    }

    // What happens when keyboard key is pressed
    // Modifies: this
    // Effects: updates facing if W, A, S, or D is pressed. Calls the move() method
    public void keyDown(String key) {
        switch (key) {
            case "W":
                facing = "up";
                move();
                break;
            case "A":
                facing = "left";
                move();
                break;
            case "S":
                facing = "down";
                move();
                break;
            case "D":
                facing = "right";
                move();
                break;
            case "␣":
                System.out.print("␣");
                break;
            default:
                break;
        }
    }

    // Move the player by 1 coordinate
    // Modifies: this
    // Effects: Adds 1 or subtracts 1 to coordinates based on the direction the player is facing
    public void move() {
        switch (facing) {
            case "up":
                y1 -= 1;
                break;
            case "right":
                x1 += 1;
                break;

            case "down":
                y1 += 1;
                break;
            case "left":
                x1 -= 1;
                break;
        
            default:
                break;

        }
        x1 = clamp(x1, 0, Main.GAME_WIDTH - 1);
        y1 = clamp(y1, 0, Main.GAME_HEIGHT - 1);

        
    }

    // Clamps value so it does not exceed min or max
    // Requires: min <= max
    // Effects: Returns value if min <= value <= max; returns max if value > max; returns min if value < min
    public int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }

    // Update the player every game tick
    // Modifies: this (to be implemented)
    // Effects: TBD
    public void update() {
        
    }

}
