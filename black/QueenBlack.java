package cz.cvut.fel.pjv.main.black;

import cz.cvut.fel.pjv.main.Main;
import cz.cvut.fel.pjv.main.SaveGame;
import cz.cvut.fel.pjv.main.white.KingWhite;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import static java.lang.System.exit;

/**
 * The QueenBlack class executes the black queen figure
 */
public class QueenBlack {
    String [] RowLetter={"a","b","c","d","e","f","g","h"};
    String [] NumberColumn={"8","7","6","5","4","3","2","1"};

    KingWhite kw = new KingWhite();
    boolean matOrShah = true;
    int move;

    //static Logger log = Logger.getLogger(QueenBlack.class.getName());
    /**
     * The QueenBlack function selects how the shape will go and moves it.If
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
        public synchronized void QueenBlack(JButton[][] chessSquares, Image[][]chessImage,
            int myX, int myY, int xLast, int yLast, int i, int j,
            int height, int width, String figureOpponent,
                               ArrayList<String> textGame){

            move = 1;
            matOrShah = false;
            for (int k = 1; k < 8; k++) {
                //Right down OK
                if(myX - (width*k) == xLast && myY - (height*k) == yLast &&
                        (figureOpponent.equals("Null") ||
                                figureOpponent.contains("White")) &&
                        !chessSquares[i+k][j+k].getName().contains("Black")){

                    for (int z = 1; z < k; z++) {
                        if (!chessSquares[i+z][j+z].getName().contains("Null")){
                            JOptionPane.showMessageDialog(null,
                                    "Error Move",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    //log.info("RIGHT DOWN Queen Black");
                    chessSquares[i + k][j + k].setName("Queen_Black");
                    chessSquares[i + k][j + k].setIcon(new ImageIcon(chessImage[0][1]));
                    chessSquares[i][j].setName("Null");
                    chessSquares[i][j].setIcon(new ImageIcon());



                    move = 0;

                    for (int l = 1; l < k; l++) {
                        System.out.println(chessSquares[i+k-l-1][j+k+l-2].getName());
                        if (chessSquares[i + k - l][j + k + l].getName().equals("King_White")) {
                            kw.KingWhite(chessSquares, chessImage,
                                    myX +(width*k)-(width*l),
                                    myY+(height*k)-(height*l),
                                    xLast, yLast, i+k-l, j+k+l,
                                    height,width,figureOpponent,textGame);
                            if (kw.getPossibleMoves() == 0 && chessSquares[i+k-l-1][j+k+l-2].getName().contains("ull")) {


                                System.out.println("MAT");
                                matOrShah = true;

                                JOptionPane.showMessageDialog(null,
                                        "Mat! Black Win!",
                                        "Info", JOptionPane.INFORMATION_MESSAGE);

                            }
                        }

                    }
                    if(figureOpponent.contains("White")){
                        textGame.add("Qx"+RowLetter[i+k]+NumberColumn[j+k]);
                    } else if (matOrShah){
                        textGame.add("Q"+RowLetter[i+k]+NumberColumn[j+k]+"#");
                        SaveGame sg = new SaveGame();
                        try {
                            sg.saveGame(textGame);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Main.main(new String[]{"-1"});
                    }else {
                        textGame.add("Q"+RowLetter[i+k]+NumberColumn[j+k]);
                    }

                    
                    //Right up
                }else if (myX - (width*k) == xLast && myY + (height*k) == yLast &&
                        (figureOpponent.equals("Null") ||
                                figureOpponent.contains("White")) &&
                        !chessSquares[i+k][j-k].getName().equals("Black")){

                    for (int z = 1; z < k; z++) {
                        if (!chessSquares[i+z][j-z].getName().contains("Null")){
                            JOptionPane.showMessageDialog(null,
                                    "Error Move",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    //log.info("Right UP Queen Black");
                    chessSquares[i + k][j - k].setName("Queen_Black");
                    chessSquares[i + k][j - k].setIcon(new ImageIcon(chessImage[0][1]));
                    chessSquares[i][j].setName("Null");
                    chessSquares[i][j].setIcon(new ImageIcon());

                    if(figureOpponent.contains("White")){
                        textGame.add("Qx"+RowLetter[i+k]+NumberColumn[j-k]);
                    } else {
                        textGame.add("Q"+RowLetter[i+k]+NumberColumn[j-k]);
                    }
                    
                    move = 0;


                    //Left down
                } else if (myX+(width*k) == xLast && myY-(height*k) == yLast &&
                        (figureOpponent.equals("Null") ||
                                figureOpponent.contains("White")) &&
                        !chessSquares[i-k][j+k].getName().contains("Black")){

                    for (int z = 1; z < k; z++) {
                        if (!chessSquares[i-z][j+z].getName().contains("Null")){
                            JOptionPane.showMessageDialog(null,
                                    "Error Move",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    //log.info("LEFT DOWN Queen Black");
                    chessSquares[i - k][j + k].setName("Queen_Black");
                    chessSquares[i - k][j + k].setIcon(new ImageIcon(chessImage[0][1]));
                    chessSquares[i][j].setName("Null");
                    chessSquares[i][j].setIcon(new ImageIcon());

                    if(figureOpponent.contains("White")){
                        textGame.add("Qx"+RowLetter[i-k]+NumberColumn[j+k]);
                    } else {
                        textGame.add("Q"+RowLetter[i-k]+NumberColumn[j+k]);
                    }
                    
                    move = 0;
                    for (int l = 1; l < 8; l++) {
                        if(chessSquares[i-l][j+l].getName().equals("King_White")){
                            System.out.println("MAT");
                            exit(-255);
                        }
                    }

                    //Left up OK
                } else if(myX+(width*k) == xLast && myY+(height*k) == yLast &&
                        (figureOpponent.equals("Null") ||
                                figureOpponent.contains("White")) &&
                        !chessSquares[i-k][j-k].getName().contains("Black")){

                    for (int z = 1; z < k; z++) {
                        if (!chessSquares[i-z][j-z].getName().contains("Null")){
                            JOptionPane.showMessageDialog(null,
                                    "Error Move",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    //log.info("LEFT UP Queen Black");
                    chessSquares[i - k][j - k].setName("Queen_Black");
                    chessSquares[i - k][j - k].setIcon(new ImageIcon(chessImage[0][1]));
                    chessSquares[i][j].setName("Null");
                    chessSquares[i][j].setIcon(new ImageIcon());

                    if(figureOpponent.contains("White")){
                        textGame.add("Qx"+RowLetter[i-k]+NumberColumn[j-k]);
                    } else {
                        textGame.add("Q"+RowLetter[i-k]+NumberColumn[j-k]);
                    }
                    
                    move = 0;


                } else if (myY + (height * k) == yLast && myX == xLast &&
                        (figureOpponent.equals("Null") ||
                                figureOpponent.contains("White")) &&
                        !chessSquares[i][j-k].getName().contains("Black")) {

                    for (int z = 1; z < k; z++) {
                        if (!chessSquares[i][j-z].getName().contains("Null")){
                            JOptionPane.showMessageDialog(null,
                                    "Error Move",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    //log.info("Forward Queen Black");
                    chessSquares[i][j - k].setName("Queen_Black");
                    chessSquares[i][j - k].setIcon(new ImageIcon(chessImage[0][1]));
                    chessSquares[i][j].setName("Null");
                    chessSquares[i][j].setIcon(new ImageIcon());

                    if(figureOpponent.contains("White")){
                        textGame.add("Qx"+RowLetter[i]+NumberColumn[j-k]);
                    } else {
                        textGame.add("Q"+RowLetter[i]+NumberColumn[j-k]);
                    }
                    
                    move = 0;


                    //Right
                } else if (myX - (width * k) == xLast && myY == yLast &&
                        (figureOpponent.equals("Null") ||
                                figureOpponent.contains("White")) &&
                        !chessSquares[i+k][j].getName().contains("Black")) {

                    for (int z = 1; z < k; z++) {
                        if (!chessSquares[i+z][j].getName().contains("Null")){
                            JOptionPane.showMessageDialog(null,
                                    "Error Move",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    //log.info("Right Queen Black");
                    chessSquares[i + k][j].setName("Queen_Black");
                    chessSquares[i + k][j].setIcon(new ImageIcon(chessImage[0][1]));
                    chessSquares[i][j].setName("Null");
                    chessSquares[i][j].setIcon(new ImageIcon());

                    if(figureOpponent.contains("White")){
                        textGame.add("Qx"+RowLetter[i+k]+NumberColumn[j]);
                    } else {
                        textGame.add("Q"+RowLetter[i+k]+NumberColumn[j]);
                    }
                    
                    move = 0;


                    //Left
                } else if (myX + (width * k) == xLast && myY == yLast &&
                        (figureOpponent.equals("Null") ||
                                figureOpponent.contains("White")) &&
                        !chessSquares[i-k][j].getName().contains("Black")) {

                    for (int z = 1; z < k; z++) {
                        if (!chessSquares[i-z][j].getName().contains("Null")){
                            JOptionPane.showMessageDialog(null,
                                    "Error Move",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    //log.info("Left Queen Black");
                    chessSquares[i - k][j].setName("Queen_Black");
                    chessSquares[i - k][j].setIcon(new ImageIcon(chessImage[0][1]));
                    chessSquares[i][j].setName("Null");
                    chessSquares[i][j].setIcon(new ImageIcon());

                    if(figureOpponent.contains("White")){
                        textGame.add("Qx"+RowLetter[i-k]+NumberColumn[j]);
                    } else {
                        textGame.add("Q"+RowLetter[i-k]+NumberColumn[j]);
                    }
                    
                    move = 0;


                    //Back
                } else if (myY - (height * k) == yLast && myX == xLast &&
                        (figureOpponent.equals("Null") ||
                                figureOpponent.contains("White")) &&
                        !chessSquares[i][j+k].getName().contains("Black")) {

                    for (int z = 1; z < k; z++) {
                        if (!chessSquares[i][j+z].getName().contains("Null")){
                            JOptionPane.showMessageDialog(null,
                                    "Error Move",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    //log.info("Back Queen Black");
                    chessSquares[i][j + k].setName("Queen_Black");
                    chessSquares[i][j + k].setIcon(new ImageIcon(chessImage[0][1]));
                    chessSquares[i][j].setName("Null");
                    chessSquares[i][j].setIcon(new ImageIcon());

                    if(figureOpponent.contains("White")){
                        textGame.add("Qx"+RowLetter[i]+NumberColumn[j+k]);
                    } else {
                        textGame.add("Q"+RowLetter[i]+NumberColumn[j+k]);
                    }
                    
                    move = 0;
                }
            }
        }

    public int getMove() {
        return move;
    }
    public void QueenBlackForLoad(JButton[][] chessSquares, Image[][]chessImage,
                                  int oldX, int oldY, int newX, int newY){
        for (int i = 1; i < 8; i++) {
            try {
                if (chessSquares[oldX + i][oldY + i].getName().equals("Queen_Black")) {
                    chessSquares[oldX + i][oldY + i].setName("Null");
                    chessSquares[oldX + i][oldY + i].setIcon(new ImageIcon());
                    chessSquares[newX][newY].setName("Queen_Black");
                    chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][1]));

                } else if (chessSquares[oldX + i][oldY - i].getName().equals("Queen_Black")) {
                    chessSquares[oldX + i][oldY - i].setName("Null");
                    chessSquares[oldX + i][oldY - i].setIcon(new ImageIcon());
                    chessSquares[newX][newY].setName("Queen_Black");
                    chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][1]));

                } else if (chessSquares[oldX - i][oldY + i].getName().equals("Queen_Black")) {
                    chessSquares[oldX - i][oldY + i].setName("Null");
                    chessSquares[oldX - i][oldY + i].setIcon(new ImageIcon());
                    chessSquares[newX][newY].setName("Queen_Black");
                    chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][1]));

                } else if (chessSquares[oldX - i][oldY - i].getName().equals("Queen_Black")) {
                    chessSquares[oldX - i][oldY - i].setName("Null");
                    chessSquares[oldX - i][oldY - i].setIcon(new ImageIcon());
                    chessSquares[newX][newY].setName("Queen_Black");
                    chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][1]));

                }else if (chessSquares[oldX][oldY - i].getName().equals("Queen_Black")){
                    chessSquares[oldX][oldY - i].setName("Null");
                    chessSquares[oldX][oldY - i].setIcon(new ImageIcon());
                    chessSquares[newX][newY].setName("Queen_Black");
                    chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][1]));

                }else if(chessSquares[oldX + i][oldY].getName().equals("Queen_Black")){
                    chessSquares[oldX + i][oldY].setName("Null");
                    chessSquares[oldX + i][oldY].setIcon(new ImageIcon());
                    chessSquares[newX][newY].setName("Queen_Black");
                    chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][1]));

                }else if (chessSquares[oldX - i][oldY].getName().equals("Queen_Black")){
                    chessSquares[oldX - i][oldY].setName("Null");
                    chessSquares[oldX - i][oldY].setIcon(new ImageIcon());
                    chessSquares[newX][newY].setName("Queen_Black");
                    chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][1]));

                }else if (chessSquares[oldX][oldY + i].getName().equals("Queen_Black")){
                    chessSquares[oldX][oldY + i].setName("Null");
                    chessSquares[oldX][oldY + i].setIcon(new ImageIcon());
                    chessSquares[newX][newY].setName("Queen_Black");
                    chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][1]));

                }
            }catch (ArrayIndexOutOfBoundsException e){
                continue;
            }
        }
    }
}
