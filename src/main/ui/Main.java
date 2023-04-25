package ui;

import javax.swing.*;

public class Main {

    public static void main(String[] args)  {

        String[] choices = { "Default", "Preset1" };
        String input = (String) JOptionPane.showInputDialog(null, "Choose now...",
                "Which mode would you like to play?", JOptionPane.QUESTION_MESSAGE, null,
                choices,
                choices[0]);


        if (input == null) {
            System.out.println("Guess you didn't want to play");
        } else {
            TileGameGui gui = new TileGameGui(input);
        }


    }

}
