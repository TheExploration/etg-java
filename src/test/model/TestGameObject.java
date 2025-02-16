package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGameObject {
    private GameObject testObject;

    @BeforeEach
    void runBefore() {
        testObject = new GameObject(1, 2, "right");

    }

    @Test
    void testGameObject() {
        GameObject g1 = new GameObject(2, 3, "up");
        assertEquals("up", g1.getFacing());
        assertEquals(2, g1.getX());
        assertEquals(3, g1.getY());
    }

    @Test
    void testGetX() {
        assertEquals(1, testObject.getX());
    }

    @Test
    void testGetY() {
        assertEquals(2, testObject.getY());
    }

    @Test
    void testGetFacing() {
        assertEquals("right", testObject.getFacing());
    }
}
