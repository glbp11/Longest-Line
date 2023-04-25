package model;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private Tile [][] grid;
    private int squareWidth;
    private int squareHeight;
    private int longestLength;
    private int totalLengthSoFar;

    public Grid(int squareWidth, int squareHeight) {
        grid = new Tile [squareWidth][squareHeight];
        this.squareHeight = squareHeight;
        this.squareWidth = squareWidth;
    }

    //EFFECTS: returns grid
    public Tile[][] getGrid() {
        return grid;
    }

    //EFFECTS: returns squareWidth
    public int getSquareWidth() {
        return squareWidth;
    }

    //EFFECTS: returns squareHeight
    public int getSquareHeight() {
        return squareHeight;
    }

    //MODIFIES: this
    //EFFECTS: adds Tile to Grid
    public boolean addTile(Tile t, int x, int y) {
//        if (checkValid(x,y) && grid[x][y] == null) {
//            grid[x][y] = t;
//            return true;
//        } else if (checkValid(x,y) && grid[x][y] != null
//                && t.isSpecial()) {
//            grid[x][y] = t;
//            return true;
//        }
//        return false;

        if (checkValid(x,y) && (grid[x][y] == null || t.isSpecial())) {
            grid[x][y] = t;
            return true;
        } else {
            return false;
        }
    }

    //EFFECTS: returns true if position of Tile trying to be added is valid, false ow
    public boolean checkValid(int x, int y) {
        boolean b;
        if (x < 0) {
            b = false;
        } else if (y < 0) {
            b = false;
        } else if (x >= squareWidth) {
            b = false;
        } else if (y >= squareHeight) {
            b = false;
        } else {
            b = true;
        }
        return b;
    }

    //EFFECTS: prints all Tile names and connections in Grid
    public String printTileList() {
        String s = " ";
        for (int r = 0; r < squareHeight; r++) {
            for (int c = 0; c < squareWidth; c++) {
                if (grid[c][r] != null) {
                    s = s + grid[c][r].getName() + " " + grid[c][r].printConnections() + " ";
                }
            }
        }
        return s;
    }

    //EFFECTS: returns list of all tiles currently on the grid
    public List<Tile> tilesOnGrid() {
        List<Tile> tilesOnGrid = new ArrayList<>();
        for (int r = 0; r < squareHeight; r++) {
            for (int c = 0; c < squareWidth; c++) {
                if (grid[c][r] != null) {
                    tilesOnGrid.add(grid[c][r]);
                }
            }
        }
        return tilesOnGrid;
    }

    //EFFECTS: returns list of position of tiles currently on grid
    //         in String form
    public List<String> positionOfTilesOnGrid() {
        List<String> positionList = new ArrayList<>();
        for (int r = 0; r < squareHeight; r++) {
            for (int c = 0; c < squareWidth; c++) {
                if (grid[c][r] != null) {
                    positionList.add(Integer.toString(c) + Integer.toString(r));
                }
            }
        }
        return positionList;
    }

    //EFFECTS: returns true if Grid has no empty spaces
    public boolean fullBoard() {
        boolean b = true;
        for (int r = 0; r < squareHeight; r++) {
            for (int c = 0; c < squareWidth; c++) {
                if (grid[c][r] == null) {
                    b = false;
                }
            }
        }
        return b;
    }

    //MODIFIES: this
    //EFFECTS: returns length of longest line in Grid
    public int longestLine() {

        for (int r = 0; r < squareHeight; r++) {
            for (int c = 0; c < squareWidth; c++) {
                if (grid[c][r] != null) {
                    for (Connection conn : grid[c][r].getConnections()) {
                        totalLengthSoFar = 0;
                        List<Connection> line = new ArrayList<>();
                        line.add(conn);
                        totalLengthSoFar = totalLengthSoFar + conn.getLength();
                        getNextTileForLine(conn.getFrom(), c, r, line);
                        getNextTileForLine(conn.getTo(), c, r, line);
                        if (longestLength < totalLengthSoFar) {
                            longestLength = totalLengthSoFar;
                        }
                    }
                }

            }
        }
        return longestLength;
    }

    //REQUIRES: d be one of "N", "E", "W", or "S"
    //EFFECTS: calls getNextFromDirection with correct parameters based on d
    public void getNextTileForLine(String d, int c, int r, List<Connection> line) {

        if (d.equals("N")) {
            if (r != 0) {
                getNextFromDirection("S",c,r - 1,line);
            }
        } else if (d.equals("E")) {
            if (c != 3) {
                getNextFromDirection("W",c + 1,r,line);
            }
        } else if (d.equals("S")) {
            if (r != 3) {
                getNextFromDirection("N",c,r + 1,line);
            }
        } else if (d.equals("W")) {
            if (c != 0) {
                getNextFromDirection("E", c - 1, r, line);
            }
        }

    }

    //EFFECTS: gets next tile in current line of connections
    public void getNextFromDirection(String d, int c, int r, List<Connection> line) {
        Tile check = grid[c][r];
        if (check != null) {
            for (Connection con : check.getConnections()) {

                if (con.getFrom().equals(d)) {
                    if (!line.contains(con)) {
                        line.add(con);
                        totalLengthSoFar = totalLengthSoFar + con.getLength();
                        getNextTileForLine(con.getTo(), c, r, line);
                    }
                } else if (con.getTo().equals((d))) {
                    if (!line.contains(con)) {
                        line.add(con);
                        totalLengthSoFar = totalLengthSoFar + con.getLength();
                        getNextTileForLine(con.getFrom(), c, r, line);
                    }
                }
            }
        }
    }
}