package model;

import javax.swing.*;
import java.util.List;

public class SpecialStubTile extends SpecialTile {

    private Icon normal;
    private Icon r1;
    private Icon r2;
    private Icon r3;

    public SpecialStubTile(String name, List<Connection> connections, Icon icon) {
        super(name, connections, icon);
        normal = new ImageIcon("SpecialStubTileIcon.png");
        r1 = new ImageIcon("SpecialStubTileR1Icon.png");
        r2 = new ImageIcon("SpecialStubTileR2Icon.png");
        r3 = new ImageIcon("SpecialStubTileR3Icon.png");
    }

    public Icon getNormal() {
        return normal;
    }

    //EFFECTS: returns r1 Icon
    public Icon getR1() {
        return r1;
    }

    //EFFECTS: returns r2 Icon
    public Icon getR2() {
        return r2;
    }

    //EFFECTS: returns r3 Icon
    public Icon getR3() {
        return r3;
    }

    public void rotateIcon(int count) {
        if (count == 1) {
            this.setIcon(r1);
        } else if (count == 2) {
            this.setIcon(r2);
        } else if (count == 3) {
            this.setIcon(r3);
        } else if (count == 4) {
            this.setIcon(normal);
        }
    }

    public Tile duplicateTile() {
        Tile t = new SpecialStubTile(this.getName(), this.getConnections(), this.getIcon());
        return t;
    }
}