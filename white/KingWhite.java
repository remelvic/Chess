package cz.cvut.fel.pjv.main.white;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * The KingWhite class executes the white King figure
 */
public class KingWhite{
    String [] RowLetter={"a","b","c","d","e","f","g","h"};
    String [] NumberColumn={"8","7","6","5","4","3","2","1"};
    int possibleMoves;
    int move;
    //static Logger log = Logger.getLogger(KingWhite.class.getName());
    /**
     * The KingWhite function selects how the shape will go and moves it.If
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
    public synchronized void KingWhite(JButton[][] chessSquares, Image[][]chessImage,
                          int myX, int myY, int xLast, int yLast, int i, int j,
                          int height, int width, String figureOpponent,
                          ArrayList<String> textGame){
        move = 0;
        possibleMoves = 0;

        //Castling long
        if(myX - (width*2) == xLast && myY == yLast && (figureOpponent.equals("Null")) && j == 7){
            chessSquares[i+2][j].setName("King_White");
            chessSquares[i+2][j].setIcon(new ImageIcon(chessImage[1][0]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());
            chessSquares[i+1][j].setName("Rook_White");
            chessSquares[i+1][j].setIcon(new ImageIcon(chessImage[1][2]));
            chessSquares[7][7].setIcon(new ImageIcon());
            chessSquares[7][7].setName("Null");
            textGame.add("O-O");
            move = 1;
        }
        if(myX + (width*2) == xLast && myY == yLast && (figureOpponent.equals("Null")) && j == 7){
            chessSquares[i-2][j].setName("King_White");
            chessSquares[i-2][j].setIcon(new ImageIcon(chessImage[1][0]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());
            chessSquares[i-1][j].setName("Rook_White");
            chessSquares[i-1][j].setIcon(new ImageIcon(chessImage[1][2]));
            chessSquares[0][7].setIcon(new ImageIcon());
            chessSquares[0][7].setName("Null");
            textGame.add("O-O-O");
            move = 1;
        }
        //left OK
        if(myX - width == xLast && myY == yLast &&
                (figureOpponent.equals("Null") ||
                        figureOpponent.contains("Black"))){
            possibleMoves = 1;
            //log.info("Left King White");
            chessSquares[i + 1][j].setName("King_White");
            chessSquares[i + 1][j].setIcon(new ImageIcon(chessImage[1][0]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());

            if(figureOpponent.contains("Black")){
                textGame.add("Kx"+RowLetter[i+1]+NumberColumn[j]);
            } else {
                textGame.add("K"+RowLetter[i+1]+NumberColumn[j]);
            }

            move = 1;


            //left up
        } else if (myX-width == xLast && myY + height == yLast &&
                (figureOpponent.equals("Null") ||
                        figureOpponent.contains("Black"))){
            possibleMoves = 1;
            //log.info("Left up King White");
            chessSquares[i + 1][j-1].setName("King_White");
            chessSquares[i + 1][j-1].setIcon(new ImageIcon(chessImage[1][0]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());

            if(figureOpponent.contains("Black")){
                textGame.add("Kx"+RowLetter[i+1]+NumberColumn[j-1]);
            } else {
                textGame.add("K"+RowLetter[i+1]+NumberColumn[j-1]);
            }

            move = 1;


            //up OK
        } else if (myX == xLast && myY + height == yLast &&
                (figureOpponent.equals("Null") ||
                        figureOpponent.contains("Black"))){
            possibleMoves = 1;
            //log.info("Up King White");
            chessSquares[i][j-1].setName("King_White");
            chessSquares[i][j-1].setIcon(new ImageIcon(chessImage[1][0]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());

            if(figureOpponent.contains("Black")){
                textGame.add("Kx"+RowLetter[i]+NumberColumn[j-1]);
            } else {
                textGame.add("K"+RowLetter[i]+NumberColumn[j-1]);
            }

            move = 1;

            //right up
        } else if (myX + width == xLast && myY + height == yLast &&
                (figureOpponent.equals("Null") ||
                        figureOpponent.contains("Black"))){
            possibleMoves = 1;
            //log.info("Right up King White");
            chessSquares[i - 1][j-1].setName("King_White");
            chessSquares[i - 1][j-1].setIcon(new ImageIcon(chessImage[1][0]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());

            if(figureOpponent.contains("Black")){
                textGame.add("Kx"+RowLetter[i-1]+NumberColumn[j-1]);
            } else {
                textGame.add("K"+RowLetter[i-1]+NumberColumn[j-1]);
            }

            move = 1;
            //right OK
        } else if (myX + width == xLast && myY == yLast &&
                (figureOpponent.equals("Null") ||
                        figureOpponent.contains("Black"))){
            possibleMoves = 1;
            //log.info("Right King White");
            chessSquares[i - 1][j].setName("King_White");
            chessSquares[i - 1][j].setIcon(new ImageIcon(chessImage[1][0]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());

            if(figureOpponent.contains("Black")){
                textGame.add("Kx"+RowLetter[i-1]+NumberColumn[j]);
            } else {
                textGame.add("K"+RowLetter[i-1]+NumberColumn[j]);
            }

            move = 1;
            //right-down
        } else if (myX + width == xLast && myY - height == yLast &&
                (figureOpponent.equals("Null") ||
                        figureOpponent.contains("Black"))){
            possibleMoves = 1;
            //log.info("Right down King White");
            chessSquares[i - 1][j+1].setName("King_White");
            chessSquares[i - 1][j+1].setIcon(new ImageIcon(chessImage[1][0]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());

            if(figureOpponent.contains("Black")){
                textGame.add("Kx"+RowLetter[i-1]+NumberColumn[j+1]);
            } else {
                textGame.add("K"+RowLetter[i-1]+NumberColumn[j+1]);
            }

            move = 1;
            //down OK
        }else if (myX == xLast && myY - height == yLast &&
                (figureOpponent.equals("Null") ||
                        figureOpponent.contains("Black"))){
            possibleMoves = 1;
            //log.info("Down King White");
            chessSquares[i][j+1].setName("King_White");
            chessSquares[i][j+1].setIcon(new ImageIcon(chessImage[1][0]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());

            if(figureOpponent.contains("Black")){
                textGame.add("Kx"+RowLetter[i]+NumberColumn[j+1]);
            } else {
                textGame.add("K"+RowLetter[i]+NumberColumn[j+1]);
            }

            move = 1;


            //left-down
        } else if (myX-width == xLast && myY - height == yLast &&
                (figureOpponent.equals("Null") ||
                        figureOpponent.contains("Black"))){
            possibleMoves = 1;
            //log.info("Left down King White");
            chessSquares[i + 1][j+1].setName("King_White");
            chessSquares[i + 1][j+1].setIcon(new ImageIcon(chessImage[1][0]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());

            if(figureOpponent.contains("Black")){
                textGame.add("Kx"+RowLetter[i+1]+NumberColumn[j+1]);
            } else {
                textGame.add("K"+RowLetter[i+1]+NumberColumn[j+1]);
            }

            move = 1;
        }
    }

    public int getMove() {
        return move;
    }
    public int getPossibleMoves(){return possibleMoves;}
    public void KingWhiteForLoad(JButton[][] chessSquares, Image[][]chessImage,
                                 int oldX, int oldY, int newX, int newY){
        if(chessSquares[oldX+1][oldY].getName().equals("King_White")){
            chessSquares[oldX+1][oldY].setName("Null");
            chessSquares[oldX+1][oldY].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("King_White");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][0]));

        } else if (chessSquares[oldX+1][oldY-1].getName().equals("King_White")){
            chessSquares[oldX+1][oldY-1].setName("Null");
            chessSquares[oldX+1][oldY-1].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("King_White");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][0]));

        }else if(chessSquares[oldX][oldY-1].getName().equals("King_White")){
            chessSquares[oldX][oldY-1].setName("Null");
            chessSquares[oldX][oldY-1].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("King_White");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][0]));

        }else if(chessSquares[oldX-1][oldY-1].getName().equals("King_White")){
            chessSquares[oldX-1][oldY-1].setName("Null");
            chessSquares[oldX-1][oldY-1].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("King_White");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][0]));

        }else if(chessSquares[oldX-1][oldY].getName().equals("King_White")){
            chessSquares[oldX-1][oldY].setName("Null");
            chessSquares[oldX-1][oldY].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("King_White");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][0]));

        }else if(chessSquares[oldX-1][oldY+1].getName().equals("King_White")){
            chessSquares[oldX-1][oldY+1].setName("Null");
            chessSquares[oldX-1][oldY+1].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("King_White");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][0]));

        }else if(chessSquares[oldX][oldY+1].getName().equals("King_White")){
            chessSquares[oldX][oldY+1].setName("Null");
            chessSquares[oldX][oldY+1].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("King_White");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][0]));

        }else if(chessSquares[oldX+1][oldY+1].getName().equals("King_White")){
            chessSquares[oldX+1][oldY+1].setName("Null");
            chessSquares[oldX+1][oldY+1].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("King_White");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][0]));

        }
    }
    public void KingWhiteForLoadCastling(JButton[][] chessSquares, Image[][]chessImage,
                                 int oldX, int oldY, int newX, int newY){
        if (oldX == 6) {
            chessSquares[oldX][oldY].setName("King_White");
            chessSquares[oldX][oldY].setIcon(new ImageIcon(chessImage[1][0]));
            chessSquares[oldX - 2][oldY].setName("Null");
            chessSquares[oldX - 2][oldY].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("Bishop_White");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][2]));
            chessSquares[7][7].setName("Null");
            chessSquares[7][7].setIcon(new ImageIcon());
        } else if(oldX == 2){
            chessSquares[oldX][oldY].setName("King_White");
            chessSquares[oldX][oldY].setIcon(new ImageIcon(chessImage[1][0]));
            chessSquares[oldX + 2][oldY].setName("Null");
            chessSquares[oldX + 2][oldY].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("Bishop_White");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[1][2]));
            chessSquares[0][7].setName("Null");
            chessSquares[0][7].setIcon(new ImageIcon());
        }
    }
}
