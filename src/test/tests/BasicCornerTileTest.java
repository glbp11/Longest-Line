package tests;

import model.BasicCornerTile;
import model.Connection;
import model.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BasicCornerTileTest {

    private Connection c;
    private List connections;
    private Icon cornerIcon;
    private BasicCornerTile t;

    @BeforeEach
    public void beforeEachTest(){
        c = new Connection("N","E", 10);
        connections = new ArrayList<>();
        connections.add(c);
        cornerIcon = new ImageIcon("CornerTileIcon.png");
        t = new BasicCornerTile("CornerTile",connections,cornerIcon);
    }

    @Test
    public void testRotateIcon1() {
        t.rotateIcon(1);
        assertFalse(t.getIcon().equals(cornerIcon));
        assertEquals(t.getIcon(),(t.getR1()));
    }

    @Test
    public void testRotateIcon2() {
        t.rotateIcon(2);
        assertFalse(t.getIcon().equals(cornerIcon));
        assertEquals(t.getIcon(),(t.getR2()));
    }

    @Test
    public void testRotateIcon3() {
        t.rotateIcon(3);
        assertFalse(t.getIcon().equals(cornerIcon));
        assertEquals(t.getIcon(),(t.getR3()));
    }

    @Test
    public void testRotateIcon4() {
        t.rotateIcon(4);
        assertFalse(t.getIcon().equals(cornerIcon));
        assertEquals(t.getIcon(),(t.getNormal()));
    }

    @Test
    public void testRotateIcon5() {
        t.rotateIcon(5);
        assertEquals(t.getIcon(),cornerIcon);
    }


    @Test
    public void testDuplicateTile() {
        Tile dup = t.duplicateTile();
        assertEquals(dup.getName(),"CornerTile");
        assertEquals(dup.getConnections(), connections);
        assertEquals(dup.getIcon(),cornerIcon);
    }
}
