package model;

import javax.swing.*;
import java.util.List;

public abstract class Tile {
    private String name;
    private List<Connection> connections;
    private Icon icon;


    //Add Image, add boolean Invulnerable, replace direction and length with Connection
    public Tile(String name, List<Connection> connections, Icon icon) {
        this.name = name;
        this.connections = connections;
        this.icon = icon;

    }

    //EFFECTS: returns Tile name
    public String getName() {
        return name;
    }

    //EFFECTS: returns Tile connections
    public List<Connection> getConnections() {
        return connections;
    }

    //EFFECTS: returns Tile icon
    public Icon getIcon() {
        return icon;
    }

    //MODIFIES: this
    //EFFECTS: sets Icon
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    //EFFECTS: prints Connections of Tile
    public String printConnections() {
        String s = "";
        for (Connection c : connections) {
            s = s + c.getFrom() + " " + c.getTo() + " ";
        }
        return s;
    }

    //MODIFIES: this
    //EFFECTS: returns tile with it's direction rotated clockwise once
    public Tile rotateConnections() {
        for (Connection c : connections) {
            c.setFrom(rotateSingleConnection(c.getFrom()));
            c.setTo(rotateSingleConnection(c.getTo()));
        }
        return this;
    }

    //REQUIRES: s be one of "N", "E", "W", "S"
    //EFFECTS: rotates given String clockwise once and returns it
    private String rotateSingleConnection(String s) {
        if (s.equals("N")) {
            return "E";
        } else if (s.equals("E")) {
            return "S";
        } else if (s.equals("S")) {
            return "W";
        } else if (s.equals("W")) {
            return "N";
        } else {
            return "C";
        }
    }


    //EFFECTS: returns true if Tile is special, false if not
    public abstract boolean isSpecial();

    //REQUIRES: 0 < count < 5
    //MODIFIES: this
    //EFFECTS: rotates icon 90 degrees clockwise and sets it
    public abstract void rotateIcon(int count);

    //EFFECTS: creates new Tile with current Tile's values and fields
    public abstract Tile duplicateTile();

    //EFFECTS: returns normal icon of this tile
    public abstract Icon getNormal();
}
