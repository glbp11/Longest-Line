package ui;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TileGameGui extends JFrame implements ActionListener {
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
    JButton b7;
    JButton b8;
    JButton b9;
    JButton b10;
    JButton b11;
    JButton b12;
    JButton b13;
    JButton b14;
    JButton b15;
    JButton b16;
    JButton b17;
    JButton b18;
    JButton b19;
    JButton b20;

    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;

    int count;
    Tile currentRotate;
    Tile currentHold;

    private TileList generator = new TileList();
    Tile currentTile = generator.randomTile(generator.randomRoll());
    Grid grid;

    public TileGameGui(String mode) {
        super("TileGameGui");

        count = 0;

        b1 = new JButton();
        b1.setBounds(10, 80, 100, 100);

        b2 = new JButton();
        b2.setBounds(110, 80, 100, 100);

        b3 = new JButton();
        b3.setBounds(210, 80, 100, 100);

        b4 = new JButton();
        b4.setBounds(310, 80, 100, 100);

        b5 = new JButton();
        b5.setBounds(10, 180, 100, 100);

        b6 = new JButton();
        b6.setBounds(110, 180, 100, 100);

        b7 = new JButton();
        b7.setBounds(210, 180, 100, 100);

        b8 = new JButton();
        b8.setBounds(310, 180, 100, 100);

        b9 = new JButton();
        b9.setBounds(10, 280, 100, 100);

        b10 = new JButton();
        b10.setBounds(110, 280, 100, 100);

        b11 = new JButton();
        b11.setBounds(210, 280, 100, 100);

        b12 = new JButton();
        b12.setBounds(310, 280, 100, 100);

        b13 = new JButton();
        b13.setBounds(10, 380, 100, 100);

        b14 = new JButton();
        b14.setBounds(110, 380, 100, 100);

        b15 = new JButton();
        b15.setBounds(210, 380, 100, 100);

        b16 = new JButton();
        b16.setBounds(310, 380, 100, 100);

        b17 = new JButton(currentTile.getIcon());
        b17.setBounds(470,120,100,100);

        b18 = new JButton("Rotate");
        b18.setBounds(470, 240, 100, 50);

        b19 = new JButton("Hold");
        b19.setBounds(630, 240, 100, 50);

        b20 = new JButton();
        b20.setBounds(630, 120, 100, 100);

        label1 = new JLabel();
        label1.setBounds(530,320,140,25);
        label1.setText("Longest line currently is:");
        label1.setForeground(Color.BLUE);

        label2 = new JLabel();
        label2.setBounds(590,360,100,25);
        label2.setForeground(Color.BLUE);

        label3 = new JLabel();
        label3.setBounds(485, 80, 100, 25);
        label3.setText("Current Tile");

        label4 = new JLabel();
        label4.setBounds(655,80,100,25);
        label4.setText("Holding");

        label5 = new JLabel();
        label5.setBounds(10,50, 300,25);
        label5.setText("Make the longest line");
        label5.setForeground(Color.darkGray);

        label6 = new JLabel();
        label6.setBounds(10, 500, 500, 25);
        label6.setText("*Special (Orange) Tiles can be placed on top of Basic (White) Tiles*");
        label6.setForeground(Color.red);

        setUpGrid(mode);

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(b10);
        add(b11);
        add(b12);
        add(b13);
        add(b14);
        add(b15);
        add(b16);
        add(b17);
        add(b18);
        add(b19);
        add(b20);
        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label5);
        add(label6);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b13.addActionListener(this);
        b14.addActionListener(this);
        b15.addActionListener(this);
        b16.addActionListener(this);
        b18.addActionListener(this);
        b19.addActionListener(this);


        setLayout(null);
        setSize(800,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void setUpGrid(String mode) {
        if (mode == "Default") {
            LengthGame lengthGame = new LengthGame();
            grid = lengthGame.loadGame();
        } else if (mode == "Preset1") {
            Preset1Game preset1Game = new Preset1Game();
            grid = preset1Game.loadGame();
            setBoardFromGrid(grid);
        } else {
            System.out.println("failed");
        }

    }

    public void actionPerformed(ActionEvent e) {
        if (grid.fullBoard()) {
            playAgain();
        } else if (e.getSource() == b1 || e.getSource() == b2 || e.getSource() == b3 || e.getSource() == b4) {
            pressedRowOne(e);
        } else if (e.getSource() == b5 || e.getSource() == b6 || e.getSource() == b7 || e.getSource() == b8) {
            pressedRowTwo(e);
        } else if (e.getSource() == b9 || e.getSource() == b10 || e.getSource() == b11 || e.getSource() == b12) {
            pressedRowThree(e);
        } else if (e.getSource() == b13 || e.getSource() == b14 || e.getSource() == b15 || e.getSource() == b16) {
            pressedRowFour(e);
        } else if (e.getSource() == b18) {
            rotateTile();
        } else if (e.getSource() == b19) {
            holdTile();
        }
    }

    public void pressedRowOne(ActionEvent e) {
        if (e.getSource() == b1) {
            if (grid.addTile(currentTile, 0,0)) {
                updateTiles(b1);
            }
        } else if (e.getSource() == b2) {
            if (grid.addTile(currentTile, 1,0)) {
                updateTiles(b2);
            }
        } else if (e.getSource() == b3) {
            if (grid.addTile(currentTile, 2,0)) {
                updateTiles(b3);
            }
        } else if (e.getSource() == b4) {
            if (grid.addTile(currentTile, 3,0)) {
                updateTiles(b4);
            }
        }
    }

    public void pressedRowTwo(ActionEvent e) {
        if (e.getSource() == b5) {
            if (grid.addTile(currentTile, 0,1)) {
                updateTiles(b5);
            }
        } else if (e.getSource() == b6) {
            if (grid.addTile(currentTile, 1,1)) {
                updateTiles(b6);
            }
        } else if (e.getSource() == b7) {
            if (grid.addTile(currentTile, 2,1)) {
                updateTiles(b7);
            }
        } else if (e.getSource() == b8) {
            if (grid.addTile(currentTile, 3,1)) {
                updateTiles(b8);
            }
        }
    }

    public void pressedRowThree(ActionEvent e) {
        if (e.getSource() == b9) {
            if (grid.addTile(currentTile, 0,2)) {
                updateTiles(b9);
            }
        } else if (e.getSource() == b10) {
            if (grid.addTile(currentTile, 1,2)) {
                updateTiles(b10);
            }
        } else if (e.getSource() == b11) {
            if (grid.addTile(currentTile, 2,2)) {
                updateTiles(b11);
            }
        } else if (e.getSource() == b12) {
            if (grid.addTile(currentTile, 3,2)) {
                updateTiles(b12);
            }
        }
    }

    public void pressedRowFour(ActionEvent e) {
        if (e.getSource() == b13) {
            if (grid.addTile(currentTile, 0,3)) {
                updateTiles(b13);
            }
        } else if (e.getSource() == b14) {
            if (grid.addTile(currentTile, 1,3)) {
                updateTiles(b14);
            }
        } else if (e.getSource() == b15) {
            if (grid.addTile(currentTile, 2,3)) {
                updateTiles(b15);
            }
        } else if (e.getSource() == b16) {
            if (grid.addTile(currentTile, 3,3)) {
                updateTiles(b16);
            }
        }
    }

    public void rotateTile() {
        countTracker();
        currentTile.rotateConnections();
        if (count == 1) {
            currentTile.rotateIcon(1);
        } else if (count == 2) {
            currentTile.rotateIcon(2);
        } else if (count == 3) {
            currentTile.rotateIcon(3);
        } else if (count == 4) {
            currentTile.rotateIcon(4);
        }
        b17.setIcon(currentTile.getIcon());
    }

    public void countTracker() {
        if (currentRotate == null) {
            currentRotate = currentTile;
            count = 1;
        } else if (currentRotate != null && currentRotate.equals(currentTile)) {
            if (count <= 3) {
                count++;
            } else {
                count = 1;
            }
            currentRotate = currentTile;
        } else if (!currentRotate.equals(currentTile)) {
            count = 1;
            currentRotate = currentTile;
        }
    }

    public void holdTile() {
        if (currentHold == null) {
            currentHold = currentTile.duplicateTile();
            b20.setIcon(currentHold.getIcon());
            currentTile = generator.randomTile(generator.randomRoll());
            b17.setIcon(currentTile.getIcon());

        } else {
            Tile temp = currentTile;
            currentTile = currentHold;
            currentHold = temp;
            b20.setIcon(currentHold.getIcon());
            b17.setIcon(currentTile.getIcon());
        }
    }

    public void updateTiles(JButton b) {
        b.setIcon(currentTile.getIcon());
        if (!grid.fullBoard()) {
            currentTile = generator.randomTile(generator.randomRoll());
            b17.setIcon(currentTile.getIcon());
            label2.setText(Integer.toString(grid.longestLine()));
        } else {
            label2.setText(Integer.toString(grid.longestLine()));
            playAgain();
        }
    }

    public void setBoardFromGrid(Grid grid) {
        for (int i = 0; i < grid.tilesOnGrid().size(); i++) {
            Tile t = grid.tilesOnGrid().get(i);
            String pos = grid.positionOfTilesOnGrid().get(i);
            String check = pos.substring(1);
            if (check.equals("0")) {
                positionToButtonRow1(t,pos);
            } else if (check.equals("1")) {
                positionToButtonRow2(t,pos);
            } else if (check.equals("2")) {
                positionToButtonRow3(t,pos);
            } else if (check.equals("3")) {
                positionToButtonRow4(t,pos);
            }
        }
    }

    public void positionToButtonRow1(Tile t, String pos) {
        if (pos.equals("00")) {
            b1.setIcon(t.getIcon());
        } else if (pos.equals("10")) {
            b2.setIcon(t.getIcon());
        } else if (pos.equals("20")) {
            b3.setIcon(t.getIcon());
        } else if (pos.equals("30")) {
            b4.setIcon(t.getIcon());
        }
    }

    public void positionToButtonRow2(Tile t, String pos) {
        if (pos.equals("01")) {
            b5.setIcon(t.getIcon());
        } else if (pos.equals("11")) {
            b6.setIcon(t.getIcon());
        } else if (pos.equals("21")) {
            b7.setIcon(t.getIcon());
        } else if (pos.equals("31")) {
            b8.setIcon(t.getIcon());
        }
    }

    public void positionToButtonRow3(Tile t, String pos) {
        if (pos.equals("02")) {
            b9.setIcon(t.getIcon());
        } else if (pos.equals("12")) {
            b10.setIcon(t.getIcon());
        } else if (pos.equals("22")) {
            b11.setIcon(t.getIcon());
        } else if (pos.equals("32")) {
            b12.setIcon(t.getIcon());
        }
    }

    public void positionToButtonRow4(Tile t, String pos) {
        if (pos.equals("03")) {
            b13.setIcon(t.getIcon());
        } else if (pos.equals("13")) {
            b14.setIcon(t.getIcon());
        } else if (pos.equals("23")) {
            b15.setIcon(t.getIcon());
        } else if (pos.equals("33")) {
            b16.setIcon(t.getIcon());
        }
    }

    public void playAgain() {
        JDialog.setDefaultLookAndFeelDecorated(true);
        int response = JOptionPane.showConfirmDialog(null,"The longest line was " + Integer.toString(grid.longestLine())
                        + "\nDo you want to play again?", "Play Again?",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION) {
            System.exit(0);
        } else if (response == JOptionPane.YES_OPTION) {
            setUpNewGame();
        } else if (response == JOptionPane.CLOSED_OPTION) {
            System.exit(0);
        }

    }

    public void setUpNewGame() {
        String[] choices = { "Default", "Preset1" };
        String input = (String) JOptionPane.showInputDialog(null, "Choose now...",
                "Which mode would you like to play?", JOptionPane.QUESTION_MESSAGE, null,
                choices,
                choices[0]);


        if (input == null) {
            System.out.println("Guess you didn't want to play");
            System.exit(0);
        } else {
            TileGameGui gui = new TileGameGui(input);
        }
    }
}


