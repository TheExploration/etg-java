package model;

import java.util.*;
import javax.swing.*;

import ui.Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener {
    private static List<GameObject> gameObjects = new ArrayList<>();
    private boolean[] keys = new boolean[256];
    private Player player;

    public Game() {
        player = new Player();

        // invisible gui for keyboard input (NOT USING GUI FOR PHASE 1)
        setUndecorated(true);
        setSize(1, 1);
        addKeyListener(this);
        setVisible(true);
        setFocusable(true);
        requestFocusInWindow();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public static void addGameObjects(GameObject g) {
        gameObjects.add(g);
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int keyCode = ke.getKeyCode();
        if (keyCode < keys.length) {
            keys[keyCode] = true;
        }
        player.keyDown(KeyEvent.getKeyText(keyCode));
        


    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int keyCode = ke.getKeyCode();
        if (keyCode < keys.length) {
            keys[keyCode] = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    public void update() {
        for (GameObject g : gameObjects) {
            g.update();
        }
    }
}
