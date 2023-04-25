package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Preset1Game implements Game {

    private Grid grid;
    private Tile t0;
    private Tile t1;
    private Tile t2;
    private Tile t3;
    private Tile t4;
    private Tile t5;

    public Preset1Game() {
        List<Connection> a0 = new ArrayList<>();
        a0.add(new Connection("N","S", 10));

        List<Connection> a1 = new ArrayList<>();
        a1.add(new Connection("N","C", 5));

        List<Connection> a2 = new ArrayList<>();
        a2.add(new Connection("N","S", 10));
        a2.add(new Connection("E","W", 10));

        List<Connection> a3 = new ArrayList<>();
        a3.add(new Connection("N","E", 10));

        List<Connection> a4 = new ArrayList<>();
        a4.add(new Connection("N", "E", 5));
        a4.add(new Connection("W", "S", 5));

        List<Connection> a5 = new ArrayList<>();
        a5.add(new Connection("N", "E", 5));
        a5.add(new Connection("W", "S", 5));

        Icon i0 = new ImageIcon("SpecialStraightTileIcon.png");
        Icon i1 = new ImageIcon("SpecialStubTileIcon.png");
        Icon i2 = new ImageIcon("SpecialPlusTileIcon.png");
        Icon i3 = new ImageIcon("SpecialCornerTileIcon.png");
        Icon i4 = new ImageIcon("SpecialDownRightTileIcon.png");
        Icon i5 = new ImageIcon("SpecialDownRightTileIcon.png");

        t0 = new SpecialStraightTile("SpecialStraightTile", a0, i0);
        t1 = new SpecialStubTile("SpecialStubTile", a1, i1);
        t2 = new SpecialPlusTile("SpecialPlusTile", a2, i2);
        t3 = new SpecialCornerTile("SpecialCornerTile", a3, i3);
        t4 = new SpecialDownRightTile("SpecialDownRightTile",a4, i4);
        t5 = new SpecialDownRightTile("SpecialDownRightTile",a5, i5);
    }

    //MODIFIES: this
    //EFFECTS: returns Grid with preset Tiles
    public Grid loadGame() {
        grid = new Grid(4,4);
        grid.addTile(t0, 0, 0);
        grid.addTile(t1, 3,3);
        grid.addTile(t2, 1, 1);
        grid.addTile(t3, 0, 3);
        grid.addTile(t4, 2,1);
        grid.addTile(t5,2,2);
        return grid;
    }

}
