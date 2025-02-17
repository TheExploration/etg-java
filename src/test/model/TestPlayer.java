package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPlayer {
    private Player testPlayer;

    @BeforeEach
    void runBefore() {
        testPlayer = new Player();
    }

    @Test
    void testPlayer() {
        Player p1 = new Player();
        assertEquals("right", p1.getFacing());
    }

    @Test
    void testGetFacing() {
        assertEquals("right", testPlayer.getFacing());
    }

    @Test
    void testKeyDown() {
        testPlayer.keyDown("W");
        assertEquals("up", testPlayer.getFacing());
        testPlayer.keyDown("A");
        assertEquals("left", testPlayer.getFacing());
        testPlayer.keyDown("S");
        assertEquals("down", testPlayer.getFacing());
        testPlayer.keyDown("D");
        assertEquals("right", testPlayer.getFacing());
        testPlayer.keyDown("␣");
        assertEquals("right", testPlayer.getFacing()); // Nothing for now
        testPlayer.keyDown("M#U)()");
        assertEquals("right", testPlayer.getFacing()); // Nothing for now
    }


    @Test
    void testMove() {
        testPlayer.keyDown("W");
        testPlayer.move();
        assertEquals(0, testPlayer.getY());
        testPlayer.keyDown("A");
        testPlayer.move();
        assertEquals(0, testPlayer.getX());
        testPlayer.keyDown("S");
        testPlayer.move();
        assertEquals(2, testPlayer.getY());
        testPlayer.keyDown("D");
        testPlayer.move();
        assertEquals(2, testPlayer.getX());

    }

    @Test
    void testClamp() {
        assertEquals(0, testPlayer.clamp(0, 0, 0));
        assertEquals(0, testPlayer.clamp(0, -2, 4));
        assertEquals(-2, testPlayer.clamp(-3, -2, 4));
        assertEquals(4, testPlayer.clamp(66, -2, 4));
    }
}
