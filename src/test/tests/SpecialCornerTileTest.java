package tests;

import model.Connection;
import model.SpecialCornerTile;
import model.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpecialCornerTileTest {

    private Connection c;
    private List connections;
    private Icon specialCornerIcon;
    private SpecialCornerTile t;

    @BeforeEach
    public void beforeEachTest(){
        c = new Connection("N","E", 10);
        connections = new ArrayList<>();
        connections.add(c);
        specialCornerIcon = new ImageIcon("SpecialCornerTileIcon.png");
        t = new SpecialCornerTile("SpecialCornerTile",connections,specialCornerIcon);
    }

    @Test
    public void testRotateIcon1() {
        t.rotateIcon(1);
        assertFalse(t.getIcon().equals(specialCornerIcon));
        assertEquals(t.getIcon(),(t.getR1()));
    }

    @Test
    public void testRotateIcon2() {
        t.rotateIcon(2);
        assertFalse(t.getIcon().equals(specialCornerIcon));
        assertEquals(t.getIcon(),(t.getR2()));
    }

    @Test
    public void testRotateIcon3() {
        t.rotateIcon(3);
        assertFalse(t.getIcon().equals(specialCornerIcon));
        assertEquals(t.getIcon(),(t.getR3()));
    }

    @Test
    public void testRotateIcon4() {
        t.rotateIcon(4);
        assertFalse(t.getIcon().equals(specialCornerIcon));
        assertEquals(t.getIcon(),(t.getNormal()));
    }

    @Test
    public void testRotateIcon5() {
        t.rotateIcon(5);
        assertTrue(t.getIcon().equals(specialCornerIcon));
    }

    @Test
    public void testDuplicateTile() {
        Tile dup = t.duplicateTile();
        assertEquals(dup.getName(),"SpecialCornerTile");
        assertEquals(dup.getConnections(), connections);
        assertEquals(dup.getIcon(),specialCornerIcon);
    }
}
