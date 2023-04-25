package tests;

import model.Connection;
import model.SpecialStraightTile;
import model.SpecialTile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpecialTileTest {
    private SpecialTile st;
    private Connection c;
    private List<Connection> connections;
    private Icon straightTileIcon;

    @BeforeEach
    public void beforeEachTest(){
        c = new Connection("N","S", 10);
        connections = new ArrayList<>();
        connections.add(c);
        straightTileIcon = new ImageIcon("StraightTileIcon.png");
        st = new SpecialStraightTile("SpecialStraightTile",connections, straightTileIcon);
    }

    @Test
    void testIsSpecial(){
        assertTrue(st.isSpecial());
    }
}
