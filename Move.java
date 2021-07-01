package cz.cvut.fel.pjv.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.logging.Logger;


/**
 * I use the Move class to define the square that the shape will go to.
 * Select the square by pressing the right mouse button
 */
public class Move {
    int x;
    int y;
    int width;
    int height;

    Logic logic = new Logic();

    String figureOpponent;
    static Logger log = Logger.getLogger(Move.class.getName());


    /**
     * The Move function determines the square the figure will move to. I also
     * find out the size of the square and its name and transfer all this to
     * the Logic class
     * @param chessSquares an array of all buttons (squares)
     * @param chessImage an array of all pieces
     * @param length determines the size of the array
     * @param textGame Will contain the whole game in pgn format
     */
    public void move(JButton[][] chessSquares, Image[][] chessImage, int length,
                     ArrayList<String> textGame) {

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int finalI = i;
                int finalJ = j;

                chessSquares[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getButton() == 3) {
                            y = ((JButton) e.getSource()).
                                    getLocationOnScreen().y;
                            x = ((JButton) e.getSource()).
                                    getLocationOnScreen().x;
                            width = ((JButton) e.getSource()).getSize().width;
                            height = ((JButton) e.getSource()).getSize().height;
                            figureOpponent = ((JButton) e.getSource()).getName();
                            System.out.println(e.getSource());
                            log.info("Where to y " + y + " x " + x);

                            log.info("Location of the selected square" +
                                    ((JButton) e.getSource()).getLocationOnScreen());
                        }

                        logic.Logic(chessSquares, chessImage, finalI, finalJ,x,y
                                ,width,height,figureOpponent,textGame);
                        return;

                    }
                });


            }

        }

    }

}
