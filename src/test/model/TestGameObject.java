package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGameObject {
    private GameObject testObject;

    @BeforeEach
    void runBefore() {
        testObject = new GameObject(1, 2);
    }

    @Test
    void testGameObject() {
        GameObject g1 = new GameObject(2, 3);
        
        assertEquals(2, g1.getX());
        assertEquals(3, g1.getY());
        g1.destroy();
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
    void testDestroy() {
        testObject.destroy();
        assertFalse(Game.getGameObjects().contains(testObject));
    }

    @Test
    void testMove() {
        testObject.move();
        // This is an abstract method. To be implemented by child.

    }

    @Test
    void testUpdate() {
        testObject.update();
        // This is an abstract method. To be implemented by child.
    }

}
