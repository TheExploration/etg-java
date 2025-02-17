package model;


public class GameObject {
    protected int x1;
    protected int y1;
    protected String facing = "up";
    protected boolean[] keys = new boolean[256];


    public GameObject(int x, int y, String facing) {
        this.x1 = x;
        this.y1 = y;
        this.facing = facing;
        Game.GAMEOBJECTS.add(this);
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

    public void destroy() {
        Game.GAMEOBJECTS.remove(this);
    }

    public void move() {
        
    }

    public void update() {

    }
}
