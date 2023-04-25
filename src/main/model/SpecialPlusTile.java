package model;

import javax.swing.*;
import java.util.List;

public class SpecialPlusTile extends SpecialTile {

    private Icon normal;

    public SpecialPlusTile(String name, List<Connection> connections, Icon icon) {
        super(name, connections, icon);
        normal = new ImageIcon("SpecialPlusTileIcon.png");
    }

    public Icon getNormal() {
        return normal;
    }

    public void rotateIcon(int count) {
        this.setIcon(normal);
    }

    public Tile duplicateTile() {
        Tile t = new SpecialPlusTile(this.getName(), this.getConnections(), this.getIcon());
        return t;
    }
}