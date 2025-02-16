package model;

public class GameObject {
    private int x1;
    private int y1;
    private String facing = "up";

    public GameObject(int x, int y, String facing) {
        this.x1 = x;
        this.y1 = y;
        this.facing = facing;
    }

    public int getX() {
        return x1;

    }

    public int getY() {
        return y1;
    }
    
    public String getFacing() {
        return facing;
    }
}
