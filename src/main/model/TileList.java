package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TileList {
    private int fullLength = 10;
    private int halfLength = 5;
    private static Map<String, List<Tile>> tiles;
    private static List<Tile> straights;
    private List<Tile> corners;
    private List<Tile> stubs;
    private List<Tile> pluss;
    private List<Tile> downRights;
    private Icon basicStraightIcon;
    private Icon basicCornerIcon;
    private Icon basicStubIcon;
    private Icon basicPlusIcon;
    private Icon basicDownRightIcon;
    private Icon specialStraightIcon;
    private Icon specialCornerIcon;
    private Icon specialStubIcon;
    private Icon specialPlusIcon;
    private Icon specialDownRightIcon;
    private int roll;

    public TileList() {
        tiles = new HashMap<>();

        straights  = new ArrayList<>();
        corners = new ArrayList<>();
        stubs = new ArrayList<>();
        pluss = new ArrayList<>();
        downRights = new ArrayList<>();

        basicStraightIcon = new ImageIcon("StraightTileIcon.png");
        basicCornerIcon = new ImageIcon("CornerTileIcon.png");
        basicStubIcon = new ImageIcon("StubTileIcon.png");
        basicPlusIcon = new ImageIcon("PlusTileIcon.png");
        basicDownRightIcon = new ImageIcon("DownRightTileIcon.png");

        specialStraightIcon = new ImageIcon("SpecialStraightTileIcon.png");
        specialCornerIcon = new ImageIcon("SpecialCornerTileIcon.png");
        specialStubIcon = new ImageIcon("SpecialStubTileIcon.png");
        specialPlusIcon = new ImageIcon("SpecialPlusTileIcon.png");
        specialDownRightIcon = new ImageIcon("SpecialDownRightTileIcon.png");

        List<Connection> straightConnectionsArray = new ArrayList<>();
        straightConnectionsArray.add(new Connection("N","S", fullLength));

        List<Connection> specialStraightConnectionsArray = new ArrayList<>();
        specialStraightConnectionsArray.add(new Connection("N","S", fullLength));

        straights.add(new BasicStraightTile("StraightTile",straightConnectionsArray, basicStraightIcon));
        straights.add(new SpecialStraightTile("SpecialStraightTile",
                specialStraightConnectionsArray, specialStraightIcon));
        tiles.put("StraightTile", straights);

        List<Connection> cornerConnectionsArray = new ArrayList<>();
        cornerConnectionsArray.add(new Connection("N","E", fullLength));

        List<Connection> specialCornerConnectionsArray = new ArrayList<>();
        specialCornerConnectionsArray.add(new Connection("N","E", fullLength));

        corners.add(new BasicCornerTile("CornerTile", cornerConnectionsArray, basicCornerIcon));
        corners.add(new SpecialCornerTile("SpecialCornerTile",specialCornerConnectionsArray, specialCornerIcon));
        tiles.put("CornerTile", corners);

        List<Connection> stubConnectionsArray = new ArrayList<>();
        stubConnectionsArray.add(new Connection("N","C", halfLength));

        List<Connection> specialStubConnectionsArray = new ArrayList<>();
        specialStubConnectionsArray.add(new Connection("N","C", halfLength));

        stubs.add(new BasicStubTile("StubTile",stubConnectionsArray, basicStubIcon));
        stubs.add(new SpecialStubTile("SpecialStubTile",specialStubConnectionsArray, specialStubIcon));
        tiles.put("StubTile", stubs);

        List<Connection> plussConnectionsArray = new ArrayList<>();
        plussConnectionsArray.add(new Connection("N","S", fullLength));
        plussConnectionsArray.add(new Connection("E","W", fullLength));

        List<Connection> specialPlussConnectionsArray = new ArrayList<>();
        specialPlussConnectionsArray.add(new Connection("N","S", fullLength));
        specialPlussConnectionsArray.add(new Connection("E","W", fullLength));

        pluss.add(new BasicPlusTile("PlusTile",plussConnectionsArray, basicPlusIcon));
        pluss.add(new SpecialPlusTile("SpecialPlusTile",specialPlussConnectionsArray, specialPlusIcon));
        tiles.put("PlusTile", pluss);

        List<Connection> downRightConnectionsArray = new ArrayList<>();
        downRightConnectionsArray.add(new Connection("N","E", halfLength));
        downRightConnectionsArray.add(new Connection("W","S", halfLength));

        List<Connection> specialDownRightConnectionsArray = new ArrayList<>();
        specialDownRightConnectionsArray.add(new Connection("N","E", halfLength));
        specialDownRightConnectionsArray.add(new Connection("W","S", halfLength));

        downRights.add(new BasicDownRightTile("DownRightTile",downRightConnectionsArray, basicDownRightIcon));
        downRights.add(new SpecialDownRightTile("SpecialDownRightTile",
                specialDownRightConnectionsArray, specialDownRightIcon));
        tiles.put("DownRightTile", downRights);

    }

    //EFFECTS: returns roll integer
    public int getRoll() {
        return roll;
    }

    //MODIFIES: this
    //EFFECTS: sets this roll to roll if 0 <= roll <= 19
    public void setRoll(int roll) {
        if (roll >= 0 && roll <= 19) {
            this.roll = roll;
        }
    }

    public int randomRoll() {
        roll = (int)(20 * Math.random());
        return roll;
    }

    //REQUIRES: 0 <= i <= 19
    //EFFECTS: creates a random tile
    public Tile randomTile(int i) {
        List<Connection> tempConnections = new ArrayList<>();
        tempConnections.add(new Connection("N","S", fullLength));
        Tile t = new BasicStraightTile("PlaceholderTile", tempConnections, null);

        if (i >= 0 && i <= 14) {
            return rolledBasicTile(t, i);
        } else {
            return rolledSpecialTile(t, i);
        }
    }

    //EFFECTS: calls createRandomTile based on which basic tile was rolled
    public Tile rolledBasicTile(Tile t, int i) {
        if (i >= 0 && i <= 2) {
            t = createRandomTile("StraightTile", 0);
        } else if (i >= 3 && i <= 5) {
            t = createRandomTile("CornerTile", 0);
        } else if (i >= 6 && i <= 8) {
            t = createRandomTile("StubTile", 0);
        } else if (i >= 9 && i <= 11) {
            t = createRandomTile("PlusTile", 0);
        } else if (i >= 12 && i <= 14) {
            t = createRandomTile("DownRightTile", 0);
        }
        return t;
    }

    //EFFECTS: calls createRandomTile based on which special tile was rolled
    public Tile rolledSpecialTile(Tile t, int i) {
        if (i == 15) {
            t = createRandomTile("StraightTile", 1);
        } else if (i == 16) {
            t = createRandomTile("CornerTile", 1);
        } else if (i == 17) {
            t = createRandomTile("StubTile", 1);
        } else if (i == 18) {
            t = createRandomTile("PlusTile", 1);
        } else if (i == 19) {
            t = createRandomTile("DownRightTile", 1);
        }
        return t;
    }

    //REQUIRES: index = 0 or index = 1
    //EFFECTS: creates a tile based on parameters
    private Tile createRandomTile(String s, int index) {
        Tile placeholder = tiles.get(s).get(index);
        if (index == 0) {
            return createSpecificBasicTile(placeholder);
        } else {
            return createSpecificSpecialTile(placeholder);
        }
    }

    //REQUIRES tile name to be one of "CornerTile", "DownRightTile", "PlusTile"
    //                                "StraightTile" or "StubTile"
    //EFFECTS: creates BasicTile of given tile t
    private Tile createSpecificBasicTile(Tile t) {
        List<Connection> connections = createNewConnections(t);
        if (t.getName() == "CornerTile") {
            return new BasicCornerTile(t.getName(), connections, t.getIcon());
        } else if (t.getName() == "DownRightTile") {
            return new BasicDownRightTile(t.getName(), connections, t.getIcon());
        } else if (t.getName() == "PlusTile") {
            return new BasicPlusTile(t.getName(), connections, t.getIcon());
        } else if (t.getName() == "StraightTile") {
            return new BasicStraightTile(t.getName(), connections, t.getIcon());
        } else {
            return new BasicStubTile(t.getName(), connections, t.getIcon());
        }
    }

    //REQUIRES tile name to be one of "SpecialCornerTile", "SpecialDownRightTile", "SpecialPlusTile"
    //                                "SpecialStraightTile" or "SpecialStubTile"
    //EFFECTS: creates SpecialTile of given tile t
    private Tile createSpecificSpecialTile(Tile t) {
        List<Connection> connections = createNewConnections(t);
        if (t.getName() == "SpecialCornerTile") {
            return new SpecialCornerTile(t.getName(), connections, t.getIcon());
        } else if (t.getName() == "SpecialDownRightTile") {
            return new SpecialDownRightTile(t.getName(), connections, t.getIcon());
        } else if (t.getName() == "SpecialPlusTile") {
            return new SpecialPlusTile(t.getName(), connections, t.getIcon());
        } else if (t.getName() == "SpecialStraightTile") {
            return new SpecialStraightTile(t.getName(), connections, t.getIcon());
        } else  {
            return new SpecialStubTile(t.getName(), connections, t.getIcon());
        }
    }

    //EFFECTS: creates duplicate connections of given Tile t
    private List<Connection> createNewConnections(Tile t) {
        List<Connection> tempConnections = new ArrayList<>();
        for (Connection c: t.getConnections()) {
            Connection temp = new Connection(c.getFrom(), c.getTo(), c.getLength());
            tempConnections.add(temp);
        }
        return tempConnections;
    }
}
