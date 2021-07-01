package cz.cvut.fel.pjv.main.black;

import cz.cvut.fel.pjv.main.Logic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The PawnBlack class executes the black pawn figure
 */
public class PawnBlack {
    String [] RowLetter={"a","b","c","d","e","f","g","h"};
    String [] NumberColumn={"8","7","6","5","4","3","2","1"};

    int move;
    int h;
    int w;
    int myx;
    int myy;
    //static Logger log = Logger.getLogger(PawnBlack.class.getName());
    /**
     * The PawnBlack function selects how the shape will go and moves it.If
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
    public synchronized void  PawnBlack(JButton[][] chessSquares, Image[][]chessImage,
                          int myX, int myY, int xLast, int yLast, int i, int j,
                          int height, int width, String figureOpponent,
                          ArrayList<String> textGame) throws ArrayIndexOutOfBoundsException{
        move = 1;
        h = height;
        w = width;
        myx = myX;
        myy = myY;
        for (int k = 1; k < 3; k++) {
            //Forward
            if(chessSquares[i][j + 1].getName().equals("Null")) {
                // for forward 2x
                if(j+k < 4) {
                    if (myY - (height * k) == yLast && myX == xLast &&
                            (figureOpponent.equals("Null") ||
                                    !figureOpponent.contains("King"))) {
                        //log.info("Forward 2x Pawn Black");
                        if(i == 0 &&
                                chessSquares[i+1][j+k].getName().contains("PawnWhite")){
                            chessSquares[i][j+k].setName("PawnBlackPassant");
                            chessSquares[i][j+k].setIcon(new ImageIcon(chessImage[0][5]));
                            chessSquares[i][j].setName("Null");
                            chessSquares[i][j].setIcon(new ImageIcon());
                            textGame.add(RowLetter[i] + NumberColumn[j + k]);
                            move = 0;
                        } else if (i == 7 &&
                                chessSquares[i-1][j+k].getName().contains("PawnWhite")){
                            chessSquares[i][j+k].setName("PawnBlackPassant");
                            chessSquares[i][j+k].setIcon(new ImageIcon(chessImage[0][5]));
                            chessSquares[i][j].setName("Null");
                            chessSquares[i][j].setIcon(new ImageIcon());
                            textGame.add(RowLetter[i] + NumberColumn[j + k]);
                            move = 0;
                        }else if(i > 0 && i < 7 &&
                                (chessSquares[i-1][j+k].getName().contains("PawnWhite") ||
                                        chessSquares[i+1][j+k].getName().contains("PawnWhite"))){
                            chessSquares[i][j + k].setName("PawnBlackPassant");
                            chessSquares[i][j + k].setIcon(new ImageIcon(chessImage[0][5]));
                            chessSquares[i][j].setName("Null");
                            chessSquares[i][j].setIcon(new ImageIcon());

                            textGame.add(RowLetter[i] + NumberColumn[j + k]);
                            move = 0;
                        } else {
                            chessSquares[i][j + k].setName("PawnBlack");
                            chessSquares[i][j + k].setIcon(new ImageIcon(chessImage[0][5]));
                            chessSquares[i][j].setName("Null");
                            chessSquares[i][j].setIcon(new ImageIcon());

                            textGame.add(RowLetter[i] + NumberColumn[j + k]);
                            move = 0;
                        }


                    }
                } else {
                    if (myY - height  == yLast && myX == xLast &&
                            figureOpponent.equals("Null")) {
                        //log.info("Forward 1x Pawn Black");
                        chessSquares[i][j + 1].setName("PawnBlack");
                        chessSquares[i][j + 1].setIcon(new ImageIcon(chessImage[0][5]));
                        chessSquares[i][j].setName("Null");
                        chessSquares[i][j].setIcon(new ImageIcon());

                        //textGame.add(RowLetter[i] + NumberColumn[j + 1]);
                        move = 0;


                        if(j + k == 7){

                            String[] options = {"Bishop", "Queen", "Rook", "Knight"};
                            int result = JOptionPane.showOptionDialog(
                                  null,
                                  "Select Figure","Info",
                                  JOptionPane.YES_NO_CANCEL_OPTION,
                                  JOptionPane.QUESTION_MESSAGE,
                                  null,
                                  options,
                                  options[0]);
                          if (result == JOptionPane.YES_OPTION){
                              chessSquares[i][j+1].setName("Bishop_Black");
                              chessSquares[i][j+1].setIcon(new ImageIcon(chessImage[0][4]));
                              textGame.add(RowLetter[i] + NumberColumn[j + 1]+"="+"B");
                          } else if (result == JOptionPane.NO_OPTION){
                              chessSquares[i][j+1].setName("Queen_Black");
                              chessSquares[i][j+1].setIcon(new ImageIcon(chessImage[0][1]));
                              textGame.add(RowLetter[i] + NumberColumn[j + 1]+"="+"Q");
                          } else if (result == JOptionPane.CANCEL_OPTION){
                              chessSquares[i][j+1].setName("Rook_Black");
                              chessSquares[i][j+1].setIcon(new ImageIcon(chessImage[0][2]));
                              textGame.add(RowLetter[i] + NumberColumn[j + 1]+"="+"R");
                          } else{
                              chessSquares[i][j+1].setName("Knight_Black");
                              chessSquares[i][j+1].setIcon(new ImageIcon(chessImage[0][3]));
                              textGame.add(RowLetter[i] + NumberColumn[j + 1]+"="+"N");
                          }
                          move = 0;
                        } else {
                            textGame.add(RowLetter[i] + NumberColumn[j + 1]);
                            move = 0;
                        }
                    }
                }
            }
        }
        if (((myY - height == yLast || myY - (height * 2) == yLast) &&
                myX == xLast) && (!figureOpponent.equals("Null") && !figureOpponent.contains("King"))) {
            Logic.errorMove();
        } else if (myY - height == yLast && myX - width == xLast &&
                (!figureOpponent.equals("Null") && !figureOpponent.contains("Black") &&
                        !figureOpponent.contains("King")
                        || chessSquares[i+1][j].getName().contains("PawnWhitePassant"))) {
            if (chessSquares[i+1][j].getName().equals("PawnWhitePassant")){
                chessSquares[i+1][j+1].setIcon(new ImageIcon(chessImage[0][5]));
                chessSquares[i+1][j+1].setName("PawnBlack");

                chessSquares[i+1][j].setName("Null");
                chessSquares[i+1][j].setIcon(new ImageIcon());
                chessSquares[i][j].setName("Null");
                chessSquares[i][j].setIcon(new ImageIcon());
                textGame.add(RowLetter[i]+"x"+RowLetter[i-1]+NumberColumn[j-1]);
                move = 0;
                return;
            }
            //log.info("Attack Pawn Black");
            chessSquares[i + 1][j + 1].setIcon(new ImageIcon(chessImage[0][5]));
            chessSquares[i + 1][j + 1].setName("PawnBlack");
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());

            if(j + 1 == 7){

                String[] options = {"Bishop", "Queen", "Rook", "Knight"};
                int result = JOptionPane.showOptionDialog(
                        null,
                        "Select Figure","Info",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                if (result == JOptionPane.YES_OPTION){
                    chessSquares[i+1][j+1].setName("Bishop_Black");
                    chessSquares[i+1][j+1].setIcon(new ImageIcon(chessImage[0][4]));
                    textGame.add(RowLetter[i]+"x"+RowLetter[i+1] + NumberColumn[j + 1]+"="+"B");
                } else if (result == JOptionPane.NO_OPTION){
                    chessSquares[i+1][j+1].setName("Queen_Black");
                    chessSquares[i+1][j+1].setIcon(new ImageIcon(chessImage[0][1]));
                    textGame.add(RowLetter[i]+"x"+RowLetter[i+1] + NumberColumn[j + 1]+"="+"Q");
                } else if (result == JOptionPane.CANCEL_OPTION){
                    chessSquares[i+1][j+1].setName("Rook_Black");
                    chessSquares[i+1][j+1].setIcon(new ImageIcon(chessImage[0][2]));
                    textGame.add(RowLetter[i]+"x"+RowLetter[i+1] + NumberColumn[j + 1]+"="+"R");
                } else{
                    chessSquares[i+1][j+1].setName("Knight_Black");
                    chessSquares[i+1][j+1].setIcon(new ImageIcon(chessImage[0][3]));
                    textGame.add(RowLetter[i]+"x"+RowLetter[i+1] + NumberColumn[j + 1]+"="+"N");
                }
                move = 0;
            } else {
                textGame.add(RowLetter[i]+"x"+RowLetter[i+1] + NumberColumn[j + 1]);
                move = 0;
            }
            //textGame.add("x"+RowLetter[i+1]+NumberColumn[j+1]);
            //move = 0;


        } else if (myY - height == yLast && myX + width == xLast &&
                ((!figureOpponent.equals("Null") && !figureOpponent.contains("Black") &&
                        !figureOpponent.contains("King")) ||
                        chessSquares[i-1][j].getName().contains("PawnWhitePassant"))) {

            if (chessSquares[i-1][j].getName().equals("PawnWhitePassant")){
                chessSquares[i-1][j+1].setIcon(new ImageIcon(chessImage[0][5]));
                chessSquares[i-1][j+1].setName("PawnBlack");

                chessSquares[i-1][j].setName("Null");
                chessSquares[i-1][j].setIcon(new ImageIcon());
                chessSquares[i][j].setName("Null");
                chessSquares[i][j].setIcon(new ImageIcon());
                textGame.add(RowLetter[i]+"x"+RowLetter[i-1]+NumberColumn[j-1]);
                move = 0;
                return;
            }
            //log.info("Attack Pawn Black Right");
            chessSquares[i - 1][j + 1].setIcon(new ImageIcon(chessImage[0][5]));
            chessSquares[i - 1][j + 1].setName("PawnBlack");
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());

            if(j + 1 == 7){

                String[] options = {"Bishop", "Queen", "Rook", "Knight"};
                int result = JOptionPane.showOptionDialog(
                        null,
                        "Select Figure","Info",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                if (result == JOptionPane.YES_OPTION){
                    chessSquares[i-1][j+1].setName("Bishop_Black");
                    chessSquares[i-1][j+1].setIcon(new ImageIcon(chessImage[0][4]));
                    textGame.add(RowLetter[i]+"x"+RowLetter[i-1] + NumberColumn[j + 1]+"="+"B");
                } else if (result == JOptionPane.NO_OPTION){
                    chessSquares[i-1][j+1].setName("Queen_Black");
                    chessSquares[i-1][j+1].setIcon(new ImageIcon(chessImage[0][1]));
                    textGame.add(RowLetter[i]+"x"+RowLetter[i-1] + NumberColumn[j + 1]+"="+"Q");
                } else if (result == JOptionPane.CANCEL_OPTION){
                    chessSquares[i-1][j+1].setName("Rook_Black");
                    chessSquares[i-1][j+1].setIcon(new ImageIcon(chessImage[0][2]));
                    textGame.add(RowLetter[i]+"x"+RowLetter[i-1] + NumberColumn[j + 1]+"="+"R");
                } else{
                    chessSquares[i-1][j+1].setName("Knight_Black");
                    chessSquares[i-1][j+1].setIcon(new ImageIcon(chessImage[0][3]));
                    textGame.add(RowLetter[i]+"x"+RowLetter[i-1] + NumberColumn[j + 1]+"="+"N");
                }
                move = 0;
            } else {
                textGame.add(RowLetter[i]+"x"+RowLetter[i-1] + NumberColumn[j + 1]);
                move = 0;
            }

        }
    }

    public void PawnBlackForLoad(JButton[][] chessSquares, Image[][]chessImage,
                                 int oldX, int oldY, int newX, int newY){
        //forward
        if(oldX == newX){
            if (chessSquares[oldX][oldY].getName().equals("Null")){
                chessSquares[oldX][oldY-1].setName("Null");
                chessSquares[oldX][oldY-1].setIcon(new ImageIcon());
                chessSquares[newX][newY].setName("PawnBlack");
                chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][5]));
            }
            chessSquares[oldX][oldY].setName("Null");
            chessSquares[oldX][oldY].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("PawnBlack");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][5]));

        }else if(oldX != newX){
            chessSquares[oldX][oldY].setName("Null");
            chessSquares[oldX][oldY].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("PawnBlack");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][5]));
        }
    }

    public int getMove(){return move;}

}
