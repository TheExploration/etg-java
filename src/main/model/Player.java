package model;

import ui.Main;

public class Player extends GameObject {

    private String facing = "up";

    public Player() {
        super(2, 2);
        facing = "right";
    }

    public String getFacing() {
        return facing;
    }


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

    public int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }

    public void update() {
        System.out.println(Integer.toString(x1) + Integer.toString(y1));
    }

}
