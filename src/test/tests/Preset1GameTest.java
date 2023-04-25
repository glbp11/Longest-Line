package tests;

import model.Grid;
import model.Preset1Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Preset1GameTest {

    Preset1Game preset1Game;
    Grid grid;

    @BeforeEach
    public void beforeEachTest() {
        preset1Game = new Preset1Game();
    }

    @Test
    public void testLoadGame() {
        grid = preset1Game.loadGame();
        assertEquals(grid.getSquareHeight(), 4);
        assertEquals(grid.getSquareWidth(),4);
        assertEquals(grid.tilesOnGrid().get(0).getName(),"SpecialStraightTile");
        assertEquals(grid.tilesOnGrid().get(1).getName(),"SpecialPlusTile");
        assertEquals(grid.tilesOnGrid().get(2).getName(),"SpecialDownRightTile");
        assertEquals(grid.tilesOnGrid().get(3).getName(),"SpecialDownRightTile");
        assertEquals(grid.tilesOnGrid().get(4).getName(),"SpecialCornerTile");
        assertEquals(grid.tilesOnGrid().get(5).getName(),"SpecialStubTile");
        assertEquals(grid.positionOfTilesOnGrid().get(0),"00");
        assertEquals(grid.positionOfTilesOnGrid().get(1),"11");
        assertEquals(grid.positionOfTilesOnGrid().get(2),"21");
        assertEquals(grid.positionOfTilesOnGrid().get(3),"22");
        assertEquals(grid.positionOfTilesOnGrid().get(4),"03");
        assertEquals(grid.positionOfTilesOnGrid().get(5),"33");

    }

}
