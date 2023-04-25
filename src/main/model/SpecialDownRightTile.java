package model;

import javax.swing.*;
import java.util.List;

public class SpecialDownRightTile extends SpecialTile {
    private Icon normal;
    private Icon r1;

    public SpecialDownRightTile(String name, List<Connection> connections, Icon icon) {
        super(name, connections, icon);
        normal = new ImageIcon("SpecialDownRightTileIcon.png");
        r1 = new ImageIcon("SpecialDownRightTileR1Icon.png");
    }

    public Icon getNormal() {
        return normal;
    }

    //EFFECTS: returns r1 Icon
    public Icon getR1() {
        return r1;
    }

    public void rotateIcon(int count) {
        if (count == 1 || count == 3) {
            this.setIcon(r1);
        } else if (count == 2 || count == 4) {
            this.setIcon(normal);
        }
    }

    public Tile duplicateTile() {
        Tile t = new SpecialDownRightTile(this.getName(), this.getConnections(), this.getIcon());
        return t;
    }
}