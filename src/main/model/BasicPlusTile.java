package model;

import javax.swing.*;
import java.util.List;

public class BasicPlusTile extends BasicTile {

    private Icon normal;

    public BasicPlusTile(String name, List<Connection> connections, Icon icon) {
        super(name, connections, icon);
        normal = new ImageIcon("PlusTileIcon.png");
    }

    public Icon getNormal() {
        return normal;
    }

    public void rotateIcon(int count) {
        this.setIcon(normal);
    }

    public Tile duplicateTile() {
        Tile t = new BasicPlusTile(this.getName(), this.getConnections(), this.getIcon());
        return t;
    }
}