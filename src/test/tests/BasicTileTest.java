package tests;

import model.BasicStraightTile;
import model.BasicTile;
import model.Connection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class BasicTileTest {
    private BasicTile t;
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
    void testIsSpecial(){
        assertFalse(t.isSpecial());
    }




}
