package cz.cvut.fel.pjv.main;

import javax.swing.*;

/*
Last update 5.16.21 4:14:36 PM
 */


/**
 * Launches the game
 * If the argument at index 0 is -1, then a new window will be launched.
 * The argument at index 0 will be -1 only when the "Restore" button was clicked.
 * The initial argument is 0
 */
public class Main {

    public static void main(String[] args) {
        JFrame jf = new JFrame("Chess");
        Board board = new Board();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                if(args[0] != "-1") {

                    jf.add(board.getWindow());
                    jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jf.setLocationByPlatform(true);
                    jf.pack();
                    jf.setMinimumSize(jf.getSize());
                    jf.setVisible(true);

                } else {
                    jf.setVisible(false);
                    board.removeAll();
                    Board board2 = new Board();
                    JFrame jf1 = new JFrame("Chess");
                    jf1.add(board2.getWindow());
                    jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    jf1.setLocationByPlatform(true);
                    jf1.pack();
                    jf1.setMinimumSize(jf1.getSize());
                    jf1.setVisible(true);
                }
            }
        });

    }
}
