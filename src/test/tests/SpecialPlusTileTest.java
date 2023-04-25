package tests;

import model.Connection;
import model.SpecialPlusTile;
import model.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialPlusTileTest {

    private Connection c;
    private Connection c1;
    private List connections;
    private Icon plusIcon;
    private SpecialPlusTile t;

    @BeforeEach
    public void beforeEachTest(){
        c = new Connection("N","S", 10);
        c1 = new Connection("E","W",10);
        connections = new ArrayList<>();
        connections.add(c);
        connections.add(c1);
        plusIcon = new ImageIcon("SpecialPlusTileIcon.png");
        t = new SpecialPlusTile("SpecialPlusTile",connections,plusIcon);
    }

    @Test
    public void testRotateIcon1() {
        t.rotateIcon(1);
        assertEquals(t.getIcon(),(t.getNormal()));
    }

    @Test
    public void testRotateIcon2() {
        t.rotateIcon(2);
        assertEquals(t.getIcon(),(t.getNormal()));
    }

    @Test
    public void testRotateIcon3() {
        t.rotateIcon(3);
        assertEquals(t.getIcon(),(t.getNormal()));
    }

    @Test
    public void testRotateIcon4() {
        t.rotateIcon(4);
        assertEquals(t.getIcon(),(t.getNormal()));
    }

    @Test
    public void testDuplicateTile() {
        Tile dup = t.duplicateTile();
        assertEquals(dup.getName(),"SpecialPlusTile");
        assertEquals(dup.getConnections(), connections);
        assertEquals(dup.getIcon(),plusIcon);
    }
}
