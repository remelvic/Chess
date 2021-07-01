package cz.cvut.fel.pjv.main;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * The Restore class Reopens the board and removes the old figures from the board
 */
public class Restore {
    /**
     * The restoreGame function has an argument of -1,
     * thus the code in the Main class starts the second window
     * @param message Changes the message in the ToolBar
     * @param e empty
     */
    public final void restoreGame(JLabel message, ActionEvent e){
        String[] args = {"-1"};
        message.setText("Game restored");
        Main.main(args);
    }
}
