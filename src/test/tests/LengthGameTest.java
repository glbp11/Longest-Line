package tests;

import model.Grid;
import model.LengthGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthGameTest {

    LengthGame lengthGame;
    Grid grid;

    @BeforeEach
    public void beforeEachTest() {
        lengthGame = new LengthGame();
    }

    @Test
    public void testLoadGame() {
        grid = lengthGame.loadGame();
        assertEquals(grid.getSquareHeight(), 4);
        assertEquals(grid.getSquareWidth(),4);
    }
}
