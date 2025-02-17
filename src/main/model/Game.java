package model;

import java.util.*;
import javax.swing.*;

import ui.Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Represents the Game. The world where all the GameObjects exist.
public class Game extends JFrame implements KeyListener {
    // List of GameObjects in the Game. There is only 1 game so it is static.
    private static List<GameObject> gameObjects = new ArrayList<>();

    // Boolean array of keyboard key codes. True if key down and false if key up.
    private boolean[] keys = new boolean[256];

    // Reference to the Player GameObject since there is only 1 player per game.
    private Player player;

    // Construct a Game. Instantiate the player. And accept keyboard input for the console UI
    // Effects: Creates a Game with a single player object. Creates an invisible GUI to accept keyboard input.
    public Game() {
        player = new Player();

        // Invisible gui for keyboard input (Not using for PHASE 1).
        setUndecorated(true);
        setSize(1, 1);
        addKeyListener(this);
        setVisible(true);
        setFocusable(true);
        requestFocusInWindow();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    // Get array of keys with pressed status
    // Effects: Return a boolean array where the index represents the key code
    public boolean[] getKeys() {
        return keys;
    }

    // Get a list of all GameObject in Game
    // Effects: Return a list of all GameObject
    public static List<GameObject> getGameObjects() {
        return gameObjects;
    }

    // Add GameObject to Game
    // Requires: GameObject g is not null
    // Modifies: Game.gameObjects
    // Effects: Adds GameObject g to the static list of GameObjects Game.gameObjects
    public static void addGameObject(GameObject g) {
        gameObjects.add(g);
    }

    // Responds upon a keyboard key press
    // Requires: KeyEvent ke is not null
    // Modifies: this
    // Effects: Sets keys[keyCode] to true and calls the Player.keyDown method with the keyboard key as a string
    @Override
    public void keyPressed(KeyEvent ke) {
        int keyCode = ke.getKeyCode();
        keys[keyCode] = true;
        player.keyDown(KeyEvent.getKeyText(keyCode));

    }

    // Responds upon the release of a keyboard key
    // Requires: KeyEvent ke is not null
    // Modifies: this
    // Effects: Sets keys[keyCode] to false
    @Override
    public void keyReleased(KeyEvent ke) {
        int keyCode = ke.getKeyCode();
        keys[keyCode] = false;

    }

    // Not used but required for interface implementation
    // Requires: e != null
    // Effects: Does nothing
    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    // Update method for the game loop
    // Modifies: Game.gameObjects
    // Effects: Calls update() for each GameObject in the list gameObjects
    public void update() {
        for (GameObject g : gameObjects) {
            g.update();
        }
    }
}
