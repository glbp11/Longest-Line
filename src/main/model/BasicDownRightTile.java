package model;

import javax.swing.*;
import java.util.List;

public class BasicDownRightTile extends BasicTile {

    private Icon normal;
    private Icon r1;

    public BasicDownRightTile(String name, List<Connection> connections, Icon icon) {
        super(name, connections, icon);
        normal = new ImageIcon("DownRightTileIcon.png");
        r1 = new ImageIcon("DownRightTileR1Icon.png");
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
        Tile t = new BasicDownRightTile(this.getName(), this.getConnections(), this.getIcon());
        return t;
    }
}