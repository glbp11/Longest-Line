package model;

public class LengthGame implements Game {

    private Grid grid;

    public LengthGame() {

    }

    //MODIFIES: this
    //EFFECTS: returns new empty Grid
    @Override
    public Grid loadGame() {
        grid = new Grid(4,4);
        return grid;
    }

}

