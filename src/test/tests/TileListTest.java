package tests;

import model.Tile;
import model.TileList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TileListTest {

    private TileList generator;

    @BeforeEach
    public void beforeEachTest() {
        generator = new TileList();
    }

    @Test
    public void testSetRoll() {
        generator.setRoll(3);
        assertEquals(3,generator.getRoll());
    }

    @Test
    public void testSetRoll0() {
        generator.setRoll(0);
        assertEquals(0,generator.getRoll());
    }

    @Test
    public void testSetRoll19() {
        generator.setRoll(19);
        assertEquals(19,generator.getRoll());
    }

    @Test
    public void testSetRollOutOfBounds() {
        generator.setRoll(21);
        assertEquals(0,generator.getRoll());
    }

    @Test
    public void testSetRollNegative() {
        generator.setRoll(-4);
        assertEquals(0,generator.getRoll());
    }

    @Test
    public void testGetRollNoRoll() {
        assertEquals(0, generator.getRoll());
    }

    @Test
    public void testRandomRoll() {
        int i = generator.randomRoll();
        assertTrue(0 <= i);
        assertTrue(i <= 19);
    }

    @Test
    public void testRandomTileNegative() {
        Tile t = generator.randomTile(-3);
        assertTrue(t.getName().equals("PlaceholderTile"));
    }
    @Test
    public void testRandomTile0() {
        generator.setRoll(0);
        int i = generator.getRoll();
        Tile t = generator.randomTile(i);
        assertTrue(t.getName().equals("StraightTile"));
    }

    @Test
    public void testRandomTile1() {
        generator.setRoll(1);
        int i = generator.getRoll();
        Tile t = generator.randomTile(i);
        assertTrue(t.getName().equals("StraightTile"));
    }

    @Test
    public void testRandomTile2() {
        generator.setRoll(2);
        int i = generator.getRoll();
        Tile t = generator.randomTile(i);
        assertTrue(t.getName().equals("StraightTile"));
    }

    @Test
    public void testRandomTile3() {
        generator.setRoll(3);
        int i = generator.getRoll();
        Tile t = generator.randomTile(i);
        assertTrue(t.getName().equals("CornerTile"));
    }

    @Test
    public void testRandomTile4() {
        generator.setRoll(4);
        int i = generator.getRoll();
        Tile t = generator.randomTile(i);
        assertTrue(t.getName().equals("CornerTile"));
    }

    @Test
    public void testRandomTile5() {
        generator.setRoll(5);
        int i = generator.getRoll();
        Tile t = generator.randomTile(i);
        assertTrue(t.getName().equals("CornerTile"));
    }

    @Test
    public void testRandomTile6() {
        generator.setRoll(6);
        int i = generator.getRoll();
        Tile t = generator.randomTile(i);
        assertTrue(t.getName().equals("StubTile"));
    }

    @Test
    public void testRandomTile7() {
        generator.setRoll(7);
        int i = generator.getRoll();
        Tile t = generator.randomTile(i);
        assertTrue(t.getName().equals("StubTile"));
    }

    @Test
    public void testRandomTile8() {
        generator.setRoll(8);
        int i = generator.getRoll();
        Tile t = generator.randomTile(i);
        assertTrue(t.getName().equals("StubTile"));
    }

    @Test
    public void testRandomTile9() {
        generator.setRoll(9);
        int i = generator.getRoll();
        Tile t = generator.randomTile(i);
        assertTrue(t.getName().equals("PlusTile"));
    }

    @Test
    public void testRandomTile12() {
        generator.setRoll(12);
        int i = generator.getRoll();
        Tile t = generator.randomTile(i);
        assertTrue(t.getName().equals("DownRightTile"));
    }

    @Test
    public void testRandomTile15() {
        generator.setRoll(15);
        int i = generator.getRoll();
        Tile t = generator.randomTile(i);
        assertTrue(t.getName().equals("SpecialStraightTile"));
    }

    @Test
    public void testRandomTile16() {
        generator.setRoll(16);
        int i = generator.getRoll();
        Tile t = generator.randomTile(i);
        assertTrue(t.getName().equals("SpecialCornerTile"));
    }

    @Test
    public void testRandomTile17() {
        generator.setRoll(17);
        int i = generator.getRoll();
        Tile t = generator.randomTile(i);
        assertTrue(t.getName().equals("SpecialStubTile"));
    }

    @Test
    public void testRandomTile18() {
        generator.setRoll(18);
        int i = generator.getRoll();
        Tile t = generator.randomTile(i);
        assertTrue(t.getName().equals("SpecialPlusTile"));
    }

    @Test
    public void testRandomTile19() {
        generator.setRoll(19);
        int i = generator.getRoll();
        Tile t = generator.randomTile(i);
        assertTrue(t.getName().equals("SpecialDownRightTile"));
    }

    @Test
    public void testRolledBasicTileNeg() {
        Tile t = generator.randomTile(0);
        Tile t1 = generator.rolledBasicTile(t, -4);
        assertEquals(t,t1);
    }

    @Test
    public void testRolledBasicTile() {
        Tile t = generator.randomTile(0);
        Tile t1 = generator.rolledBasicTile(t, 18);
        assertEquals(t,t1);
    }

    @Test
    public void testRolledSpecialTile() {
        Tile t = generator.randomTile(0);
        Tile t1 = generator.rolledSpecialTile(t, 20);
        assertEquals(t, t1);
    }
}
