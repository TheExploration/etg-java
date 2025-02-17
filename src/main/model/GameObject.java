package model;

// Represents an object that exists in the game. Ex: Player, Enemy, Gun, etc
public class GameObject {
    // x and y coordinate of GameObject
    protected int x1;
    protected int y1;

    // Construct a GameObject
    // Effects: Creates a GameObject this updated with x and y coordinates. Adds this to the static list gameObjects in the Game class
    public GameObject(int x, int y) {
        this.x1 = x;
        this.y1 = y;
        Game.addGameObjects(this);
    }

    // Get x coordinate
    // Effects: Returns x1
    public int getX() {
        return x1;

    }

    // Get y coordinate
    // Effects: Returns y1
    public int getY() {
        return y1;
    }

    // Destroy GameObject. To be overriden by child
    // Modifies: Game.gameObjects
    // Effects: Removes the reference to this in the static list Game.gameObjects
    public void destroy() {
        Game.getGameObjects().remove(this);
    }

    // Move method for GameObject. To be implemented by child
    public void move() {
        // To be implemented by child
    }

    //Update method for GameObject. Is called each game tick.
    public void update() {
        // To be implemented by child
    }
}
