package tests;

import model.Connection;
import model.SpecialDownRightTile;
import model.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SpecialDownRightTileTest {

    private Connection c;
    private Connection c2;
    private List connections;
    private Icon downRightIcon;
    private SpecialDownRightTile t;

    @BeforeEach
    public void beforeEachTest(){
        c = new Connection("N","E", 5);
        c2 = new Connection("W","S",5);
        connections = new ArrayList<>();
        connections.add(c);
        connections.add(c2);
        downRightIcon = new ImageIcon("SpecialDownRightTileIcon.png");
        t = new SpecialDownRightTile("SpecialDownRightTile",connections,downRightIcon);
    }

    @Test
    public void testRotateIcon1() {
        t.rotateIcon(1);
        assertFalse(t.getIcon().equals(downRightIcon));
        assertEquals(t.getIcon(),(t.getR1()));
    }

    @Test
    public void testRotateIcon2() {
        t.rotateIcon(2);
        assertFalse(t.getIcon().equals(downRightIcon));
        assertEquals(t.getIcon(),(t.getNormal()));
    }

    @Test
    public void testRotateIcon3() {
        t.rotateIcon(3);
        assertFalse(t.getIcon().equals(downRightIcon));
        assertEquals(t.getIcon(),(t.getR1()));
    }

    @Test
    public void testRotateIcon4() {
        t.rotateIcon(4);
        assertFalse(t.getIcon().equals(downRightIcon));
        assertEquals(t.getIcon(),(t.getNormal()));
    }

    @Test
    public void testRotateIcon5() {
        t.rotateIcon(5);
        assertEquals(t.getIcon(),downRightIcon);
    }

    @Test
    public void testDuplicateTile() {
        Tile dup = t.duplicateTile();
        assertEquals(dup.getName(),"SpecialDownRightTile");
        assertEquals(dup.getConnections(), connections);
        assertEquals(dup.getIcon(),downRightIcon);
    }
}
