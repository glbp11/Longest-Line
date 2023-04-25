package model;

import javax.swing.*;
import java.util.List;

public abstract class BasicTile extends Tile {


    public BasicTile(String name, List<Connection> connections, Icon icon) {
        super(name, connections, icon);
    }

    public boolean isSpecial() {
        return false;
    }

    public abstract void rotateIcon(int count);

    public abstract Tile duplicateTile();

    public abstract Icon getNormal();
}
