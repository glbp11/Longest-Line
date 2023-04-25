package tests;

import model.BasicStubTile;
import model.Connection;
import model.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BasicStubTileTest {

    private Connection c;
    private List connections;
    private Icon stubIcon;
    private BasicStubTile t;

    @BeforeEach
    public void beforeEachTest(){
        c = new Connection("N","C", 5);
        connections = new ArrayList<>();
        connections.add(c);
        stubIcon = new ImageIcon("StubTileIcon.png");
        t = new BasicStubTile("StubTile",connections,stubIcon);
    }

    @Test
    public void testRotateIcon1() {
        t.rotateIcon(1);
        assertFalse(t.getIcon().equals(stubIcon));
        assertEquals(t.getIcon(),(t.getR1()));
    }

    @Test
    public void testRotateIcon2() {
        t.rotateIcon(2);
        assertFalse(t.getIcon().equals(stubIcon));
        assertEquals(t.getIcon(),(t.getR2()));
    }

    @Test
    public void testRotateIcon3() {
        t.rotateIcon(3);
        assertFalse(t.getIcon().equals(stubIcon));
        assertEquals(t.getIcon(),(t.getR3()));
    }

    @Test
    public void testRotateIcon4() {
        t.rotateIcon(4);
        assertFalse(t.getIcon().equals(stubIcon));
        assertEquals(t.getIcon(),(t.getNormal()));
    }

    @Test
    public void testRotateIcon5() {
        t.rotateIcon(5);
        assertEquals(t.getIcon(),stubIcon);
    }

    @Test
    public void testDuplicateTile() {
        Tile dup = t.duplicateTile();
        assertEquals(dup.getName(),"StubTile");
        assertEquals(dup.getConnections(), connections);
        assertEquals(dup.getIcon(),stubIcon);
    }
}
