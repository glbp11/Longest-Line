package tests;

import model.BasicStraightTile;
import model.BasicStubTile;
import model.Connection;
import model.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TileTest {
    private Tile t;
    private Connection c;
    private List<Connection> connections;
    private Icon straightIcon;
    @BeforeEach
    void beforeEachTest(){
        c = new Connection("N","S", 10);
        connections = new ArrayList<>();
        connections.add(c);
        straightIcon = new ImageIcon("StraightTileIcon.png");
        t = new BasicStraightTile("StraightTile",connections,straightIcon);
    }

    @Test
    void testGetName(){
        assertEquals("StraightTile",t.getName());
    }

    @Test
    void testGetConnections(){
        assertEquals(connections, t.getConnections());
    }

    @Test
    void testGetIcon(){
        assertEquals(straightIcon, t.getIcon());
    }

    @Test
    void testSetIcon() {
        Icon i = new ImageIcon("StraightTileR1Icon.png");
        t.setIcon(i);
        assertEquals(i,t.getIcon());
    }
    @Test
    void testPrintConnections(){
        assertEquals("N" + " " + "S" + " ",t.printConnections());
        Connection tempC = new Connection ("E","W",10);
        connections.add(tempC);
        assertEquals("N" + " " + "S" + " " + "E" + " " + "W" + " ", t.printConnections());
    }

    @Test
    void testRotateOnce(){
        t.rotateConnections();
        assertEquals("E", t.getConnections().get(0).getFrom());
        assertEquals("W", t.getConnections().get(0).getTo());
    }
    @Test
    void testRotateTwice(){
        t.rotateConnections();
        t.rotateConnections();
        assertEquals("S", t.getConnections().get(0).getFrom());
        assertEquals("N", t.getConnections().get(0).getTo());
    }

    @Test
    void testRotateThrice() {
        t.rotateConnections();
        t.rotateConnections();
        t.rotateConnections();
        assertEquals("W",t.getConnections().get(0).getFrom());
        assertEquals("E",t.getConnections().get(0).getTo());
    }

    @Test
    void testRotateFive(){
        t.rotateConnections();
        t.rotateConnections();
        t.rotateConnections();
        t.rotateConnections();
        t.rotateConnections();
        assertEquals("E", t.getConnections().get(0).getFrom());
        assertEquals("W", t.getConnections().get(0).getTo());
    }

    @Test
    void testRotateC() {
        Connection c1 = new Connection("N","C",5);
        List<Connection> conn = new ArrayList<>();
        conn.add(c1);
        Tile t1 = new BasicStubTile("StubTile",conn,(new ImageIcon("StubTileIcon.png")));
        t1.rotateConnections();
        assertEquals("E",t1.getConnections().get(0).getFrom());
        assertEquals("C",t1.getConnections().get(0).getTo());
    }


}

