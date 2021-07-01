package cz.cvut.fel.pjv.main.black;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * The RookBlack class executes the black rook figure
 */
public class RookBlack {
    String [] RowLetter={"a","b","c","d","e","f","g","h"};
    String [] NumberColumn={"8","7","6","5","4","3","2","1"};


    int move;
    boolean error;
    //static Logger log = Logger.getLogger(RookBlack.class.getName());

    /**
     * The RookBlack function selects how the shape will go and moves it.If
     * the selected move is placed on a white piece, an error window will appear.
     * @param chessSquares an array of all buttons (squares)
     * @param chessImage an array of all pieces
     * @param myX X-coordinates where the figure is going
     * @param myY Y-coordinates where the figure is going
     * @param xLast X-coordinates from where the shape is coming from
     * @param yLast Y-coordinates from where the shape is coming from
     * @param i determines the size of the array in x
     * @param j determines the size of the array in y
     * @param height of one square is used to move shapes in Y
     * @param width of one square is used to move shapes in X
     * @param figureOpponent contains the name of the square that we chose
     *                       where we will go
     */

    public synchronized void RookBlack(JButton[][] chessSquares, Image[][]chessImage,
                          int myX, int myY, int xLast, int yLast, int i, int j,
                          int height, int width, String figureOpponent,
                          ArrayList<String> textGame) throws
            ArrayIndexOutOfBoundsException{
        move = 1;
        error = false;
        for (int k = 1; k < 8 ; k++) {
            //Forward
            if (myY - (height * k) == yLast && myX == xLast &&
                    (figureOpponent.equals("Null") ||
                            figureOpponent.contains("White")) &&
                    !chessSquares[i][j+k].getName().contains("Black")){
                for (int z = 1; z < k; ++z){
                    if(!chessSquares[i][j+z].getName().contains("Null")){
                        JOptionPane.showMessageDialog(null,
                                "Error Move",
                                "Error", JOptionPane.ERROR_MESSAGE);

                        return;
                    }
                }
                    //log.info("Forward Rook Black");
                    chessSquares[i][j + k].setName("Rook_Black");
                    chessSquares[i][j + k].setIcon(new ImageIcon(chessImage[0][2]));
                    chessSquares[i][j].setName("Null");
                    chessSquares[i][j].setIcon(new ImageIcon());

                    if (figureOpponent.contains("White")) {
                        textGame.add("Rx" + RowLetter[i] + NumberColumn[j + k]);
                    } else {
                        textGame.add("R" + RowLetter[i] + NumberColumn[j + k]);
                    }

                    move = 0;
                    error = true;
                //Right
            } else if (myX - (width * k) == xLast && myY == yLast &&
                    (figureOpponent.equals("Null") ||
                            figureOpponent.contains("White")) &&
                    !chessSquares[i+k][j].getName().contains("Black")) {
                for (int z = 1; z < k; ++z){
                    if(!chessSquares[i+z][j].getName().contains("Null")){
                        JOptionPane.showMessageDialog(null,
                                "Error Move",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                //log.info("Right Rook Black");
                chessSquares[i + k][j].setName("Rook_Black");
                chessSquares[i + k][j].setIcon(new ImageIcon(chessImage[0][2]));
                chessSquares[i][j].setName("Null");
                chessSquares[i][j].setIcon(new ImageIcon());

                if (figureOpponent.contains("White")) {
                    textGame.add("Rx" + RowLetter[i + k] + NumberColumn[j]);
                } else {
                    textGame.add("R" + RowLetter[i + k] + NumberColumn[j]);
                }

                move = 0;
                error = true;

                //Left
            } else if (myX + (width * k) == xLast && myY == yLast &&
                    (figureOpponent.equals("Null") ||
                            figureOpponent.contains("White")) &&
                    !chessSquares[i-k][j].getName().contains("Black")){
                for (int z = 1; z < k; ++z){
                    if(!chessSquares[i-z][j].getName().contains("Null")){
                        JOptionPane.showMessageDialog(null,
                                "Error Move",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                //log.info("Left Rook Black");
                chessSquares[i - k][j].setName("Rook_Black");
                chessSquares[i - k][j].setIcon(new ImageIcon(chessImage[0][2]));
                chessSquares[i][j].setName("Null");
                chessSquares[i][j].setIcon(new ImageIcon());
                if (figureOpponent.contains("White")) {
                    textGame.add("Rx" + RowLetter[i - k] + NumberColumn[j]);
                } else {
                    textGame.add("R" + RowLetter[i - k] + NumberColumn[j]);
                }

                move = 0;
                error = true;
                //Back
            } else if (myY + (height * k) == yLast && myX == xLast &&
                    (figureOpponent.equals("Null") ||
                            figureOpponent.contains("White")) &&
                    !chessSquares[i][j-k].getName().contains("Black")){

                for (int z = 1; z < k; ++z){
                    if(!chessSquares[i][j-z].getName().contains("Null")){
                        JOptionPane.showMessageDialog(null,
                                "Error Move",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                //log.info("Back Rook Black");
                chessSquares[i][j - k].setName("Rook_Black");
                chessSquares[i][j - k].setIcon(new ImageIcon(chessImage[0][2]));
                chessSquares[i][j].setName("Null");
                chessSquares[i][j].setIcon(new ImageIcon());
                if (figureOpponent.contains("White")) {
                    textGame.add("Rx" + RowLetter[i] + NumberColumn[j - k]);
                } else {
                    textGame.add("R" + RowLetter[i] + NumberColumn[j - k]);
                }

                move = 0;
                error = true;
            }
        }
        if(!error){
            JOptionPane.showMessageDialog(null,
                    "Error Move", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int getMove() {
        return move;
    }

    public void RookBlackForLoad(JButton[][] chessSquares, Image[][]chessImage,
                                 int oldX, int oldY, int newX, int newY){
        for (int i = 1; i < 8; i++) {
            try {
                if (chessSquares[oldX][oldY - i].getName().equals("Rook_Black")) {
                    chessSquares[oldX][oldY - i].setName("Null");
                    chessSquares[oldX][oldY - i].setIcon(new ImageIcon());
                    chessSquares[newX][newY].setName("Rook_Black");
                    chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][2]));

                } else if (chessSquares[oldX+i][oldY].getName().equals("Rook_Black")){
                    chessSquares[oldX+i][oldY].setName("Null");
                    chessSquares[oldX+i][oldY].setIcon(new ImageIcon());
                    chessSquares[newX][newY].setName("Rook_Black");
                    chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][2]));

                } else if (chessSquares[oldX-i][oldY].getName().equals("Rook_Black")){
                    chessSquares[oldX-i][oldY].setName("Null");
                    chessSquares[oldX-i][oldY].setIcon(new ImageIcon());
                    chessSquares[newX][newY].setName("Rook_Black");
                    chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][2]));

                }else if (chessSquares[oldX][oldY + i].getName().equals("Rook_Black")){
                    chessSquares[oldX][oldY + i].setName("Null");
                    chessSquares[oldX][oldY + i].setIcon(new ImageIcon());
                    chessSquares[newX][newY].setName("Rook_Black");
                    chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][2]));
                }
            }catch (ArrayIndexOutOfBoundsException e){
                continue;
            }
        }
    }
}
