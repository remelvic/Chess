package cz.cvut.fel.pjv.main.white;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * The KnightWhite class executes the white Knight figure
 */
public class KnightWhite{
    String [] RowLetter={"a","b","c","d","e","f","g","h"};
    String [] NumberColumn={"8","7","6","5","4","3","2","1"};
    int possibleWinWhite;

    int move;
    //static Logger log = Logger.getLogger(KnightWhite.class.getName());
    /**
     * The KnightWhite function selects how the shape will go and moves it.If
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
    public synchronized void KnightWhite(JButton[][] chessSquares, Image[][]chessImage,
                            int myX, int myY, int xLast, int yLast, int i, int j,
                            int height, int width, String figureOpponent,
                            ArrayList<String> textGame){
        move = 0;
        possibleWinWhite = 0;
        if(myX - width == xLast && myY - (height*2) == yLast &&
                (figureOpponent.equals("Null") ||
                        figureOpponent.contains("Black"))){
            //log.info("Forward right down OK Knight White");
            chessSquares[i+1][j+2].setName("Knight_White");
            chessSquares[i+1][j+2].setIcon(new ImageIcon(chessImage[1][3]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());

            if(figureOpponent.contains("Black")) {
                textGame.add("Nx"+RowLetter[i+1] + NumberColumn[j+2]);
            }else {
                textGame.add("N"+RowLetter[i+1] + NumberColumn[j+2]);
            }

            move = 1;
            //forward right up OK
        } else if (myX - (width*2) == xLast && myY - height == yLast &&
                (figureOpponent.equals("Null") ||
                        figureOpponent.contains("Black"))){
            //log.info("Forward right up OK Knight White");
            chessSquares[i+2][j+1].setName("Knight_White");
            chessSquares[i+2][j+1].setIcon(new ImageIcon(chessImage[1][3]));
            chessSquares[i][j].setIcon(new ImageIcon());
            chessSquares[i][j].setName("Null");

            if(figureOpponent.contains("Black")){
                textGame.add("Nx"+RowLetter[i+2]+NumberColumn[j+1]);
            } else {
                textGame.add("N"+RowLetter[i+2]+NumberColumn[j+1]);
            }

            move = 1;
            //forward left up OK
        } else if (myX + (width*2) == xLast && myY - height == yLast &&
                (figureOpponent.equals("Null") ||
                        figureOpponent.contains("Black"))){
            //log.info("Forward left up Knight White");
            chessSquares[i-2][j+1].setName("Knight_White");
            chessSquares[i-2][j+1].setIcon(new ImageIcon(chessImage[1][3]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());

            if (figureOpponent.contains("Black")){
                textGame.add("Nx"+RowLetter[i-2]+NumberColumn[j+1]);
            } else {
                textGame.add("N"+RowLetter[i-2]+NumberColumn[j+1]);
            }

            move = 1;
            //forward left down OK
        } else if (myX + width == xLast && myY - (height*2) == yLast &&
                (figureOpponent.equals("Null") ||
                        figureOpponent.contains("Black"))){
            //log.info("Forward left down Knight White");
            chessSquares[i-1][j+2].setName("Knight_White");
            chessSquares[i-1][j+2].setIcon(new ImageIcon(chessImage[1][3]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());

            if(figureOpponent.contains("Black")){
                textGame.add("Nx"+RowLetter[i-1]+NumberColumn[j+2]);
            } else{
                textGame.add("N"+RowLetter[i-1]+NumberColumn[j+2]);
            }

            move = 1;
            //back right down OK
        } else if (myX - (width*2) == xLast && myY + height == yLast &&
                (figureOpponent.equals("Null") ||
                        figureOpponent.contains("Black"))){
            //log.info("Back right down Knight White");
            chessSquares[i+2][j-1].setName("Knight_White");
            chessSquares[i+2][j-1].setIcon(new ImageIcon(chessImage[1][3]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());

            if(figureOpponent.contains("Black")){
                textGame.add("Nx"+RowLetter[i+2]+NumberColumn[j-1]);
            } else {
                textGame.add("N"+RowLetter[i+2]+NumberColumn[j-1]);
            }

            move = 1;
            //back right up OK
        } else if (myX - width == xLast && myY +(height*2) == yLast &&
                (figureOpponent.equals("Null") ||
                        figureOpponent.contains("Black"))){
            //log.info("Back right up Knight White");
            chessSquares[i+1][j-2].setName("Knight_White");
            chessSquares[i+1][j-2].setIcon(new ImageIcon(chessImage[1][3]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());

            if (figureOpponent.contains("Black")){
                textGame.add("Nx"+RowLetter[i+1]+NumberColumn[j-2]);
            } else {
                textGame.add("N"+RowLetter[i+1]+NumberColumn[j-2]);
            }

            move = 1;
            //back left up OK
        } else if (myX + width == xLast && myY + (height*2) == yLast &&
                (figureOpponent.equals("Null") ||
                        figureOpponent.contains("Black"))){
            //log.info("BACK LEFT UP Knight White");
            chessSquares[i-1][j-2].setName("Knight_White");
            chessSquares[i-1][j-2].setIcon(new ImageIcon(chessImage[1][3]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());

            if(figureOpponent.contains("Black")){
                textGame.add("Nx"+RowLetter[i-1]+NumberColumn[j-2]);
            }else {
                textGame.add("N"+RowLetter[i-1]+NumberColumn[j-2]);
            }

            move = 1;
            //back left down OK
        } else if (myX + (width*2) == xLast && myY + height == yLast &&
                (figureOpponent.equals("Null") ||
                        figureOpponent.contains("Black"))){
            //log.info("BACK LEFT DOWN Knight White");
            chessSquares[i-2][j-1].setName("Knight_White");
            chessSquares[i-2][j-1].setIcon(new ImageIcon(chessImage[1][3]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());

            if (figureOpponent.contains("Black")){
                textGame.add("Nx"+RowLetter[i-2]+NumberColumn[j-1]);
            } else {
                textGame.add("N"+RowLetter[i-2]+NumberColumn[j-1]);
            }

            move = 1;

        }
    }

    public int getMove() {
        return move;
    }

    public void KnightWhiteForLoad(JButton[][] chessSquares, Image[][]chessImage,
                                   int oldX, int oldY, int newX, int newY){
        if(oldX != 0 &&
                chessSquares[oldX-1][oldY+2].getName().equals("Knight_White")) {
            chessSquares[oldX - 1][oldY + 2].setName("Null");
            chessSquares[oldX - 1][oldY + 2].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("Knight_White");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][3]));

        } else if(oldX != 0 && oldY != 0 &&
                chessSquares[oldX-2][oldY-1].getName().equals("Knight_White")){
            chessSquares[oldX - 2][oldY - 1].setName("Null");
            chessSquares[oldX - 2][oldY - 1].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("Knight_White");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][3]));

        } else if( oldX != 0 && oldY != 0 &&
                chessSquares[oldX-1][oldY-2].getName().equals("Knight_White")) {
            chessSquares[oldX - 1][oldY - 2].setName("Null");
            chessSquares[oldX - 1][oldY - 2].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("Knight_White");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][3]));

        }else if(oldY != 0 &&
                chessSquares[oldX+1][oldY-2].getName().equals("Knight_White")) {
            chessSquares[oldX + 1][oldY - 2].setName("Null");
            chessSquares[oldX + 1][oldY - 2].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("Knight_White");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][3]));

        } else if(oldY != 0 &&
                chessSquares[oldX+2][oldY-1].getName().equals("Knight_White")) {
            chessSquares[oldX + 2][oldY - 1].setName("Null");
            chessSquares[oldX + 2][oldY - 1].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("Knight_White");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][3]));

        }else if(oldX != 0 &&
                chessSquares[oldX-2][oldY+1].getName().equals("Knight_White")) {
            chessSquares[oldX - 2][oldY + 1].setName("Null");
            chessSquares[oldX - 2][oldY + 1].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("Knight_White");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][3]));

        } else if(chessSquares[oldX+2][oldY+1].getName().equals("Knight_White")) {
            chessSquares[oldX + 2][oldY + 1].setName("Null");
            chessSquares[oldX + 2][oldY + 1].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("Knight_White");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][3]));

        }else if(chessSquares[oldX+1][oldY+2].getName().equals("Knight_White")) {
            chessSquares[oldX + 1][oldY + 2].setName("Null");
            chessSquares[oldX + 1][oldY + 2].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("Knight_White");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][3]));
        }
    }
}
