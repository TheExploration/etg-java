package model;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestEnemy {
    
    private Enemy enemyTest;
    private Player player;

    @BeforeEach
    void runBefore() {
        player = new Player();
        enemyTest = new Enemy(3, 3, player);
    }

    @Test
    void testEnemy() {
        Enemy e = new Enemy(0, 0, player);
        List<GameObject> gameObjs = Game.getGameObjects();
        assertEquals(gameObjs.get(gameObjs.size() - 1), e);
    }

    @Test
    void testMove() {
        enemyTest.move();
        // No easy method of testing random
    }

    @Test
    void testClamp() {
        assertEquals(0, enemyTest.clamp(0, 0, 0));
        assertEquals(0, enemyTest.clamp(0, -2, 4));
        assertEquals(-2, enemyTest.clamp(-3, -2, 4));
        assertEquals(4, enemyTest.clamp(66, -2, 4));
    }

    @Test
    void testUpdate() {
        for (int i = 0; i < 60; i++) {
            enemyTest.update();
        }
    }


}
