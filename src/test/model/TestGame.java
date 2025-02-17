package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGame {
    private Game game;

    @BeforeEach
    void runBefore() {
        game = new Game();

    }

    @Test
    void testGame() {
        Game g = new Game();
        //Nothing to test, invisible GUI code is for KeyInput.
    }

    @Test
    void testUpdate() {
        
    }
}
