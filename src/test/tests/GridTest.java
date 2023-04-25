package tests;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GridTest {
    Grid g;
    Tile t0;
    Tile t1;
    Tile t2;
    Connection c0;
    Connection c1a;
    Connection c1b;
    Connection c2;
    List <Connection> l0;
    List <Connection> l1;
    List <Connection> l2;
    private Icon basicStraightIcon;
    private Icon basicPlusIcon;
    private Icon specialStubIcon;

    @BeforeEach
    void beforeEachTest(){
        g = new Grid(4,4);

        c0 = new Connection("N","S",10);
        l0 = new ArrayList<>();
        l0.add(c0);
        basicStraightIcon = new ImageIcon("StraightTileIcon.png");
        t0 = new BasicStraightTile("StraightTile",l0, basicStraightIcon);

        c1a = new Connection("N","S",10);
        c1b = new Connection("E","W", 10);
        l1 = new ArrayList<>();
        l1.add(c1a);
        l1.add(c1b);
        basicPlusIcon = new ImageIcon("PlusTileIcon.png");
        t1 = new BasicPlusTile("PlusTile",l1, basicPlusIcon);

        c2 = new Connection("N","C",5);
        l2 = new ArrayList<>();
        l2.add(c2);
        specialStubIcon = new ImageIcon("SpecialStubTileIcon.png");
        t2 = new SpecialStubTile("SpecialStubTile",l2, specialStubIcon);
    }

    @Test
    void testGetSquareWidth() {
        assertEquals(4,g.getSquareWidth());
    }

    @Test
    void testGetSquareHeight() {
        assertEquals(4,g.getSquareHeight());
    }

    @Test
    void testGetGrid() {
        Tile [][] temp = g.getGrid();
        for (int r = 0; r < g.getSquareHeight(); r++) {
            for (int c = 0; c < g.getSquareWidth(); c++) {
                assertEquals(null, temp[c][r]);
            }
        }
    }

    @Test
    void testAddTile(){
        assertTrue(g.addTile(t0,0,0));
        assertEquals(g.getGrid()[0][0],t0);

    }

    @Test
    void testAddTiles(){
        assertTrue(g.addTile(t0,1,3));
        assertTrue(g.addTile(t2,3,2));
        assertEquals(g.getGrid()[1][3],t0);
        assertEquals(g.getGrid()[3][2],t2);
    }

    @Test
    void testAddTileOccupied(){
        assertTrue(g.addTile(t0,0,0));
        assertFalse(g.addTile(t1,0,0));
        assertEquals(g.getGrid()[0][0],t0);
    }

    @Test
    void testAddTileOccupiedSpecial(){
        assertTrue(g.addTile(t0,0,0));
        assertTrue(g.addTile(t2,0,0));
        assertEquals(g.getGrid()[0][0],t2);
    }

    @Test
    void testAddTileCheckValidFalseGridNull() {
        assertFalse(g.addTile(t0,-3,1));
    }

    @Test
    void testAddTileSecondElseIf() {

    }

    @Test
    void testPrintTileList() {
        g.addTile(t0, 0,0);
        g.addTile(t1, 1,1);
        g.addTile(t2, 2,2);
        assertEquals(" StraightTile N S  PlusTile N S E W  SpecialStubTile N C  ",g.printTileList());
    }

    @Test
    void testTilesOnGrid() {
        g.addTile(t0,3,0);
        g.addTile(t1,1,2);
        List<Tile> list = g.tilesOnGrid();
        assertEquals(list.get(0),t0);
        assertEquals(list.get(1),t1);
    }

    @Test
    void testTilesOnGridDifferentOrder() {
        g.addTile(t0,1,2);
        g.addTile(t1,3,0);
        List<Tile> list = g.tilesOnGrid();
        assertEquals(list.get(0),t1);
        assertEquals(list.get(1),t0);
    }

    @Test
    void testPositionOfTilesOnGrid() {
        g.addTile(t0,1,3);
        g.addTile(t1,3,3);
        List<String> list = g.positionOfTilesOnGrid();
        assertEquals("13",list.get(0));
        assertEquals("33",list.get(1));
    }

    @Test
    void testPositionOfTilesOnGridDifferentOrder() {
        g.addTile(t0,3,3);
        g.addTile(t1,1,3);
        List<String> list = g.positionOfTilesOnGrid();
        assertEquals("13",list.get(0));
        assertEquals("33",list.get(1));
    }

    @Test
    void testFullBoardFalse() {
        assertFalse(g.fullBoard());
    }

    @Test
    void testFullBoardFalseContainsSomeTiles() {
        g.addTile(t0,1,3);
        assertFalse(g.fullBoard());
    }
    @Test
    void testFullBoardTrue() {
        for (int r = 0; r < g.getSquareHeight(); r++) {
            for (int c = 0; c < g.getSquareWidth(); c++) {
                g.addTile(t0, c, r);
            }
        }
        assertTrue(g.fullBoard());
    }

    @Test
    void testLongestLineOneTile() {
        g.addTile(t0, 0,0);
        assertEquals(10,g.longestLine());
    }

    @Test
    void testLongestLineTwoTiles() {
        g.addTile(t0,1,1);
        g.addTile(t1,1,2);
        assertEquals(20,g.longestLine());
    }

    @Test
    void testLongestLineLeftBottomSide() {
        g.addTile(t1,0,3);
        assertEquals(10,g.longestLine());
    }

    @Test
    void testLongestLineRightSide() {
        g.addTile(t1,3,3);
        assertEquals(10,g.longestLine());
    }

    @Test
    void testGetNextTileForLineNotOption() {
        g.getNextTileForLine("O",0,0,new ArrayList<>());
        assertEquals(0,g.longestLine());
    }

    @Test
    void testSameTileSomehowPlaced() {
        List<Connection> line = t0.getConnections();
        g.addTile(t0, 0, 0);
        g.getNextFromDirection("N",0,0,line);
        assertEquals(10,g.longestLine());

    }

    @Test
    void testSameTileRotatedSomehowPlaced() {
        List<Connection> line = t0.getConnections();
        g.addTile(t0, 0, 0);
        g.getNextFromDirection("S",0,0,line);
        assertEquals(10,g.longestLine());
    }

    @Test
    void testCheckValid() {
        assertTrue(g.checkValid(1,3));

    }

    @Test
    void testCheckValidXNeg() {
        assertFalse(g.checkValid(-1,3));

    }

    @Test
    void testCheckValidYNeg() {
        assertFalse(g.checkValid(1,-3));

    }

    @Test
    void testCheckValidXBig() {
        assertFalse(g.checkValid(5,3));
    }

    @Test
    void testCheckValidYBig() {
        assertFalse(g.checkValid(1,5));

    }
}
