package model;

import javax.swing.*;
import java.util.List;

public abstract class SpecialTile extends Tile {

    public SpecialTile(String name, List<Connection> connections, Icon icon) {
        super(name, connections, icon);

    }

    public boolean isSpecial() {
        return true;
    }

    public abstract void rotateIcon(int count);

    public abstract Tile duplicateTile();

    public abstract Icon getNormal();
}

