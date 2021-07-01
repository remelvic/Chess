package cz.cvut.fel.pjv.main.white;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * The QueenWhite class executes the white queen figure
 */
public class QueenWhite{
    String [] RowLetter={"a","b","c","d","e","f","g","h"};
    String [] NumberColumn={"8","7","6","5","4","3","2","1"};
    int possibleWinWhite;
    int move;
    //static Logger log = Logger.getLogger(QueenWhite.class.getName());
    /**
     * The QueenWhite function selects how the shape will go and moves it.If
     * the selected move is placed on a black piece, an error window will appear.
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
    public synchronized void QueenWhite(JButton[][] chessSquares, Image[][]chessImage,
                           int myX, int myY, int xLast, int yLast, int i, int j,
                           int height, int width, String figureOpponent,
                           ArrayList<String> textGame){
        move = 0;
        possibleWinWhite = 0;

        for (int k = 1; k < 8; k++) {
            //Right down OK
            if(myX - (width*k) == xLast && myY - (height*k) == yLast &&
                    (figureOpponent.equals("Null") ||
                            figureOpponent.contains("Black")) &&
                    !chessSquares[i+k][j+k].getName().contains("White")){

                for (int z = 1; z < k; z++) {
                    if (!chessSquares[i+z][j+z].getName().contains("Null")){
                        JOptionPane.showMessageDialog(null,
                                "Error Move",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                //log.info("RIGHT DOWN Queen White");
                chessSquares[i + k][j + k].setName("Queen_White");
                chessSquares[i + k][j + k].setIcon(new ImageIcon(chessImage[1][1]));
                chessSquares[i][j].setName("Null");
                chessSquares[i][j].setIcon(new ImageIcon());

                if(figureOpponent.contains("Black")){
                    textGame.add("Qx"+RowLetter[i+k]+NumberColumn[j+k]);
                } else {
                    textGame.add("Q"+RowLetter[i+k]+NumberColumn[j+k]);
                }
                
                move = 1;

                break;
                //Right up
            }else if (myX - (width*k) == xLast && myY + (height*k) == yLast &&
                    (figureOpponent.equals("Null") ||
                            figureOpponent.contains("Black")) &&
                    !chessSquares[i+k][j-k].getName().contains("White")){

                for (int z = 1; z < k; z++) {
                    if (!chessSquares[i+z][j-z].getName().contains("Null")){
                        JOptionPane.showMessageDialog(null,
                                "Error Move",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                //log.info("Right UP Queen White");
                chessSquares[i + k][j - k].setName("Queen_White");
                chessSquares[i + k][j - k].setIcon(new ImageIcon(chessImage[1][1]));
                chessSquares[i][j].setName("Null");
                chessSquares[i][j].setIcon(new ImageIcon());

                if(figureOpponent.contains("Black")){
                    textGame.add("Qx"+RowLetter[i+k]+NumberColumn[j-k]);
                } else {
                    textGame.add("Q"+RowLetter[i+k]+NumberColumn[j-k]);
                }
                
                move = 1;

                break;
                //Left down
            } else if (myX+(width*k) == xLast && myY-(height*k) == yLast &&
                    (figureOpponent.equals("Null") ||
                            figureOpponent.contains("Black")) &&
                    !chessSquares[i-k][j+k].getName().contains("White")){

                for (int z = 1; z < k; z++) {
                    if (!chessSquares[i-z][j+z].getName().contains("Null")){
                        JOptionPane.showMessageDialog(null,
                                "Error Move",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                //log.info("LEFT DOWN Queen White");
                chessSquares[i - k][j + k].setName("Queen_White");
                chessSquares[i - k][j + k].setIcon(new ImageIcon(chessImage[1][1]));
                chessSquares[i][j].setName("Null");
                chessSquares[i][j].setIcon(new ImageIcon());

                if(figureOpponent.contains("Black")){
                    textGame.add("Qx"+RowLetter[i-k]+NumberColumn[j+k]);
                } else {
                    textGame.add("Q"+RowLetter[i-k]+NumberColumn[j+k]);
                }
                
                move = 1;

                break;
                //Left up OK
            } else if(myX+(width*k) == xLast && myY+(height*k) == yLast &&
                    (figureOpponent.equals("Null") ||
                            figureOpponent.contains("Black")) &&
                    !chessSquares[i-k][j-k].getName().contains("White")){

                for (int z = 1; z < k; z++) {
                    if (!chessSquares[i-z][j-z].getName().contains("Null")){
                        JOptionPane.showMessageDialog(null,
                                "Error Move",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                //log.info("LEFT UP Queen White");
                chessSquares[i - k][j - k].setName("Queen_White");
                chessSquares[i - k][j - k].setIcon(new ImageIcon(chessImage[1][1]));
                chessSquares[i][j].setName("Null");
                chessSquares[i][j].setIcon(new ImageIcon());

                if(figureOpponent.contains("Black")){
                    textGame.add("Qx"+RowLetter[i-k]+NumberColumn[j-k]);
                } else {
                    textGame.add("Q"+RowLetter[i-k]+NumberColumn[j-k]);
                }
                
                move = 1;

                break;
            } else if (myY + (height * k) == yLast && myX == xLast &&
                    (figureOpponent.equals("Null") ||
                            figureOpponent.contains("Black")) &&
                    !chessSquares[i][j-k].getName().contains("White")) {

                for (int z = 1; z < k; z++) {
                    if (!chessSquares[i][j-z].getName().contains("Null")){
                        JOptionPane.showMessageDialog(null,
                                "Error Move",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                //log.info("Forward Queen White");
                chessSquares[i][j - k].setName("Queen_White");
                chessSquares[i][j - k].setIcon(new ImageIcon(chessImage[1][1]));
                chessSquares[i][j].setName("Null");
                chessSquares[i][j].setIcon(new ImageIcon());

                if(figureOpponent.contains("Black")){
                    textGame.add("Qx"+RowLetter[i]+NumberColumn[j-k]);
                } else {
                    textGame.add("Q"+RowLetter[i]+NumberColumn[j-k]);
                }
                
                move = 1;

                break;
                //Right
            } else if (myX - (width * k) == xLast && myY == yLast &&
                    (figureOpponent.equals("Null") ||
                            figureOpponent.contains("Black")) &&
                    !chessSquares[i+k][j].getName().contains("White")) {

                for (int z = 1; z < k; z++) {
                    if (!chessSquares[i+z][j].getName().contains("Null")){
                        JOptionPane.showMessageDialog(null,
                                "Error Move",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                //log.info("Right Queen White");
                chessSquares[i + k][j].setName("Queen_White");
                chessSquares[i + k][j].setIcon(new ImageIcon(chessImage[1][1]));
                chessSquares[i][j].setName("Null");
                chessSquares[i][j].setIcon(new ImageIcon());

                if(figureOpponent.contains("Black")){
                    textGame.add("Qx"+RowLetter[i+k]+NumberColumn[j]);
                } else {
                    textGame.add("Q"+RowLetter[i+k]+NumberColumn[j]);
                }
                
                move = 1;

                break;
                //Left
            } else if (myX + (width * k) == xLast && myY == yLast &&
                    (figureOpponent.equals("Null") ||
                            figureOpponent.contains("Black")) &&
                    !chessSquares[i-k][j].getName().contains("White")) {

                for (int z = 1; z < k; z++) {
                    if (!chessSquares[i-z][j].getName().contains("Null")){
                        JOptionPane.showMessageDialog(null,
                                "Error Move",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                //log.info("LEFT Queen White");
                chessSquares[i - k][j].setName("Queen_White");
                chessSquares[i - k][j].setIcon(new ImageIcon(chessImage[1][1]));
                chessSquares[i][j].setName("Null");
                chessSquares[i][j].setIcon(new ImageIcon());

                if(figureOpponent.contains("Black")){
                    textGame.add("Qx"+RowLetter[i-k]+NumberColumn[j]);
                } else {
                    textGame.add("Q"+RowLetter[i-k]+NumberColumn[j]);
                }
                
                move = 1;

                break;
                //Back
            } else if (myY - (height * k) == yLast && myX == xLast &&
                    (figureOpponent.equals("Null") ||
                            figureOpponent.contains("Black")) &&
                    !chessSquares[i][j+k].getName().contains("White")) {

                for (int z = 1; z < k; z++) {
                    if (!chessSquares[i][j+z].getName().contains("Null")){
                        JOptionPane.showMessageDialog(null,
                                "Error Move",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                //log.info("Back Queen White");
                chessSquares[i][j + k].setName("Queen_White");
                chessSquares[i][j + k].setIcon(new ImageIcon(chessImage[1][1]));
                chessSquares[i][j].setName("Null");
                chessSquares[i][j].setIcon(new ImageIcon());

                if(figureOpponent.contains("Black")){
                    textGame.add("Qx"+RowLetter[i]+NumberColumn[j+k]);
                } else {
                    textGame.add("Q"+RowLetter[i]+NumberColumn[j+k]);
                }
                
                move = 1;

                break;
            }
        }
    }

    public int getMove() {
        return move;
    }

    public void QueenWhiteForLoad(JButton[][] chessSquares, Image[][]chessImage,
                                  int oldX, int oldY, int newX, int newY){
        for (int i = 1; i < 8; i++) {
            try {
                if (chessSquares[oldX + i][oldY + i].getName().equals("Queen_White")) {
                    chessSquares[oldX + i][oldY + i].setName("Null");
                    chessSquares[oldX + i][oldY + i].setIcon(new ImageIcon());
                    chessSquares[newX][newY].setName("Queen_White");
                    chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][1]));

                } else if (chessSquares[oldX + i][oldY - i].getName().equals("Queen_White")) {
                    chessSquares[oldX + i][oldY - i].setName("Null");
                    chessSquares[oldX + i][oldY - i].setIcon(new ImageIcon());
                    chessSquares[newX][newY].setName("Queen_White");
                    chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][1]));

                } else if (chessSquares[oldX - i][oldY + i].getName().equals("Queen_White")) {
                    chessSquares[oldX - i][oldY + i].setName("Null");
                    chessSquares[oldX - i][oldY + i].setIcon(new ImageIcon());
                    chessSquares[newX][newY].setName("Queen_White");
                    chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][1]));

                } else if (chessSquares[oldX - i][oldY - i].getName().equals("Queen_White")) {
                    chessSquares[oldX - i][oldY - i].setName("Null");
                    chessSquares[oldX - i][oldY - i].setIcon(new ImageIcon());
                    chessSquares[newX][newY].setName("Queen_White");
                    chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][1]));

                }else if (chessSquares[oldX][oldY - i].getName().equals("Queen_White")){
                    chessSquares[oldX][oldY - i].setName("Null");
                    chessSquares[oldX][oldY - i].setIcon(new ImageIcon());
                    chessSquares[newX][newY].setName("Queen_White");
                    chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][1]));

                }else if(chessSquares[oldX + i][oldY].getName().equals("Queen_White")){
                    chessSquares[oldX + i][oldY].setName("Null");
                    chessSquares[oldX + i][oldY].setIcon(new ImageIcon());
                    chessSquares[newX][newY].setName("Queen_White");
                    chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][1]));

                }else if (chessSquares[oldX - i][oldY].getName().equals("Queen_White")){
                    chessSquares[oldX - i][oldY].setName("Null");
                    chessSquares[oldX - i][oldY].setIcon(new ImageIcon());
                    chessSquares[newX][newY].setName("Queen_White");
                    chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][1]));

                }else if (chessSquares[oldX][oldY + i].getName().equals("Queen_White")){
                    chessSquares[oldX][oldY + i].setName("Null");
                    chessSquares[oldX][oldY + i].setIcon(new ImageIcon());
                    chessSquares[newX][newY].setName("Queen_White");
                    chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][1]));

                }
            }catch (ArrayIndexOutOfBoundsException e){
                continue;
            }
        }
    }
}
