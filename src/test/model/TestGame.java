package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.event.KeyEvent;
import java.util.*;

import javax.swing.JTextField;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGame {
    private Game game;
    private GameObject testObject;

    @BeforeEach
    void runBefore() {
        game = new Game();
        testObject = new GameObject(2, 4);

    }

    @Test
    void testGame() {
        Player testPlayer = new Player();
        // Since static, checking if the intial Game made a Player obj as first obj. In runBefore()
        assertEquals(testPlayer.getClass(), Game.getGameObjects().get(0).getClass());
        //Nothing to test, invisible GUI code is for KeyInput.
    }

    @Test
    void testGetGameObjects() {
    
        Game.addGameObject(testObject);
        List<GameObject> single = Game.getGameObjects();
        assertEquals(testObject, single.get(single.size() - 1));
        assertFalse(Game.getGameObjects().isEmpty());

    }

    @Test
    void testKeyPressed() {
        game.keyPressed(new KeyEvent(new JTextField(), 0, System.currentTimeMillis(), 0, KeyEvent.VK_A, 'a'));
        boolean[] keys = game.getKeys();
        assertTrue(keys[KeyEvent.VK_A]);
    }

    @Test
    void testKeyReleased() {
        game.keyPressed(new KeyEvent(new JTextField(), 0, System.currentTimeMillis(), 0, KeyEvent.VK_A, 'a'));
        boolean[] keys = game.getKeys();
        assertTrue(keys[KeyEvent.VK_A]);
        game.keyReleased(new KeyEvent(new JTextField(), 0, System.currentTimeMillis(), 0, KeyEvent.VK_A, 'a'));
        assertFalse(keys[KeyEvent.VK_A]);
    }
 
    @Test
    void testGetKeys() {
        game.keyPressed(new KeyEvent(new JTextField(), 0, System.currentTimeMillis(), 0, KeyEvent.VK_A, 'a'));
        boolean[] keys = game.getKeys();
        assertTrue(keys[KeyEvent.VK_A]);

    }

    // Method is not used. It is only required for implementing interface
    @Test
    void testKeyTyped() {
        game.keyTyped(null);
    }

    @Test
    void testUpdate() {
        game.update();
    }
}
