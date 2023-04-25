package model;

import javax.swing.*;
import java.util.List;

public class BasicStraightTile extends BasicTile {

    private Icon normal;
    private Icon r1;

    public BasicStraightTile(String name, List<Connection> connections, Icon icon) {
        super(name, connections, icon);
        normal = new ImageIcon("StraightTileIcon.png");
        r1 = new ImageIcon("StraightTileR1Icon.png");
    }

    public Icon getNormal() {
        return normal;
    }

    //EFFECTS: returns r1 icon
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
        Tile t = new BasicStraightTile(this.getName(), this.getConnections(), this.getIcon());
        return t;
    }
}


