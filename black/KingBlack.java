package cz.cvut.fel.pjv.main.black;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * The KingBlack class executes the black King figure
 */
public class KingBlack {
    String [] RowLetter={"a","b","c","d","e","f","g","h"};
    String [] NumberColumn={"8","7","6","5","4","3","2","1"};
    boolean shahOrMat;
    int validMoves;
    int move;
    //static Logger log = Logger.getLogger(KingBlack.class.getName());

    /**
     * The KingBlack function selects how the shape will go and moves it.If
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
    public synchronized void KingBlack(JButton[][] chessSquares, Image[][]chessImage,
                          int myX, int myY, int xLast, int yLast, int i, int j,
                          int height, int width, String figureOpponent,
                          ArrayList<String> textGame){
        move = 1;
        validMoves = 0;
        //Right

        //Castling Long
        if(myX - (width*2) == xLast && myY == yLast && (figureOpponent.equals("Null")) && j == 0){
            chessSquares[i+2][j].setName("King_Black");
            chessSquares[i+2][j].setIcon(new ImageIcon(chessImage[0][0]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());
            chessSquares[i+1][j].setName("Rook_Black");
            chessSquares[i+1][j].setIcon(new ImageIcon(chessImage[0][2]));
            chessSquares[7][0].setIcon(new ImageIcon());
            chessSquares[7][0].setName("Null");
            textGame.add("O-O-O");
            move = 0;
        }
        //Castling short
        if (myX + (width*2) == xLast && myY == yLast && (figureOpponent.equals("Null")) && j == 0){
            chessSquares[i-2][j].setName("King_Black");
            chessSquares[i-2][j].setIcon(new ImageIcon(chessImage[0][0]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());
            chessSquares[i-1][j].setName("Rook_Black");
            chessSquares[i-1][j].setIcon(new ImageIcon(chessImage[0][2]));
            chessSquares[0][0].setIcon(new ImageIcon());
            chessSquares[0][0].setName("Null");
            textGame.add("O-O");
            move = 0;
        }

        if(myX - width == xLast && myY == yLast &&
                (figureOpponent.equals("Null") ||
                        figureOpponent.contains("White"))){
            //log.info("Right King Black");

            chessSquares[i + 1][j].setName("King_Black");
            chessSquares[i + 1][j].setIcon(new ImageIcon(chessImage[0][0]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());

            if(figureOpponent.contains("White")){
                textGame.add("Kx"+RowLetter[i+1]+NumberColumn[j]);
            } else {
                textGame.add("K"+RowLetter[i+1]+NumberColumn[j]);
            }
            
            move = 0;

            //left up
        } else if (myX-width == xLast && myY + height == yLast &&
                (figureOpponent.equals("Null") ||
                        figureOpponent.contains("White"))){
            //log.info("Left up King Black");
            chessSquares[i + 1][j-1].setName("King_Black");
            chessSquares[i + 1][j-1].setIcon(new ImageIcon(chessImage[0][0]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());

            if(figureOpponent.contains("White")){
                textGame.add("Kx"+RowLetter[i+1]+NumberColumn[j-1]);
            } else {
                textGame.add("K"+RowLetter[i+1]+NumberColumn[j-1]);
            }
            
            move = 0;

            //up OK
        } else if (myX == xLast && myY + height == yLast &&
                (figureOpponent.equals("Null") ||
                        figureOpponent.contains("White"))){
            //log.info("Up King Black")
            chessSquares[i][j-1].setName("King_Black");
            chessSquares[i][j-1].setIcon(new ImageIcon(chessImage[0][0]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());

            if(figureOpponent.contains("White")){
                textGame.add("Kx"+RowLetter[i]+NumberColumn[j-1]);
            } else {
                textGame.add("K"+RowLetter[i]+NumberColumn[j-1]);
            }
            
            move = 0;

            //right up
        } else if (myX + width == xLast && myY + height == yLast &&
                (figureOpponent.equals("Null") ||
                        figureOpponent.contains("White"))){
            //log.info("Right up King Black");
            chessSquares[i - 1][j-1].setName("King_Black");
            chessSquares[i - 1][j-1].setIcon(new ImageIcon(chessImage[0][0]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());

            if(figureOpponent.contains("White")){
                textGame.add("Kx"+RowLetter[i-1]+NumberColumn[j-1]);
            } else {
                textGame.add("K"+RowLetter[i-1]+NumberColumn[j-1]);
            }
            
            move = 0;

            //left OK
        } else if (myX + width == xLast && myY == yLast &&
                (figureOpponent.equals("Null") ||
                        figureOpponent.contains("White"))){
            //log.info("Left King Black");
            chessSquares[i - 1][j].setName("King_Black");
            chessSquares[i - 1][j].setIcon(new ImageIcon(chessImage[0][0]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());

            if(figureOpponent.contains("White")){
                textGame.add("Kx"+RowLetter[i-1]+NumberColumn[j]);
            } else {
                textGame.add("K"+RowLetter[i-1]+NumberColumn[j]);
            }
            
            move = 0;

            //right-down
        } else if (myX + width == xLast && myY - height == yLast &&
                (figureOpponent.equals("Null") ||
                        figureOpponent.contains("White"))){
            //log.info("Right down King Black");
            System.out.println("Right - down ");
            chessSquares[i - 1][j+1].setName("King_Black");
            chessSquares[i - 1][j+1].setIcon(new ImageIcon(chessImage[0][0]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());

            if(figureOpponent.contains("White")){
                textGame.add("Kx"+RowLetter[i-1]+NumberColumn[j+1]);
            } else {
                textGame.add("K"+RowLetter[i-1]+NumberColumn[j+1]);
            }
            
            move = 0;

            //down OK
        }else if (myX == xLast && myY - height == yLast &&
                (figureOpponent.equals("Null") ||
                        figureOpponent.contains("White")) &&
                !chessSquares[i][j+1].getName().contains("Black")){
            System.out.println("DOWN ");
            //log.info("Down King Black")
            chessSquares[i][j+1].setName("King_Black");
            chessSquares[i][j+1].setIcon(new ImageIcon(chessImage[0][0]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());

            if(figureOpponent.contains("White")){
                textGame.add("Kx"+RowLetter[i]+NumberColumn[j+1]);
            } else {
                textGame.add("K"+RowLetter[i]+NumberColumn[j+1]);
            }
            
            move = 0;

            //left-down RIGHT DOWN
        } else if (myX-width == xLast && myY - height == yLast &&
                (figureOpponent.equals("Null") ||
                        figureOpponent.contains("White"))){
            System.out.println("Down black left");
            //log.info("Left down King Black");
            chessSquares[i + 1][j+1].setName("King_Black");
            chessSquares[i + 1][j+1].setIcon(new ImageIcon(chessImage[0][0]));
            chessSquares[i][j].setName("Null");
            chessSquares[i][j].setIcon(new ImageIcon());

            if(figureOpponent.contains("White")){
                textGame.add("Kx"+RowLetter[i+1]+NumberColumn[j+1]);
            } else {
                textGame.add("K"+RowLetter[i+1]+NumberColumn[j+1]);
            }
            
            move = 0;
        }
    }

    public int getMove() {
        return move;
    }

    public boolean getShahOrMat(){
        return shahOrMat;
    }

    public void KingBlackForLoad(JButton[][] chessSquares, Image[][]chessImage,
                                 int oldX, int oldY, int newX, int newY){
        if(chessSquares[oldX+1][oldY].getName().equals("King_Black")){
            chessSquares[oldX+1][oldY].setName("Null");
            chessSquares[oldX+1][oldY].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("King_Black");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][0]));

        } else if (chessSquares[oldX+1][oldY-1].getName().equals("King_Black")){
            chessSquares[oldX+1][oldY-1].setName("Null");
            chessSquares[oldX+1][oldY-1].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("King_Black");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][0]));

        }else if(chessSquares[oldX][oldY-1].getName().equals("King_Black")){
            chessSquares[oldX][oldY-1].setName("Null");
            chessSquares[oldX][oldY-1].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("King_Black");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][0]));

        }else if(chessSquares[oldX-1][oldY-1].getName().equals("King_Black")){
            chessSquares[oldX-1][oldY-1].setName("Null");
            chessSquares[oldX-1][oldY-1].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("King_Black");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][0]));

        }else if(chessSquares[oldX-1][oldY].getName().equals("King_Black")){
            chessSquares[oldX-1][oldY].setName("Null");
            chessSquares[oldX-1][oldY].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("King_Black");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][0]));

        }else if(chessSquares[oldX-1][oldY+1].getName().equals("King_Black")){
            chessSquares[oldX-1][oldY+1].setName("Null");
            chessSquares[oldX-1][oldY+1].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("King_Black");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][0]));

        }else if(chessSquares[oldX][oldY+1].getName().equals("King_Black")){
            chessSquares[oldX][oldY+1].setName("Null");
            chessSquares[oldX][oldY+1].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("King_Black");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][0]));

        }else if(chessSquares[oldX+1][oldY+1].getName().equals("King_Black")){
            chessSquares[oldX+1][oldY+1].setName("Null");
            chessSquares[oldX+1][oldY+1].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("King_Black");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][0]));

        }
    }
    public void KingBlackForLoadCastling(JButton[][] chessSquares, Image[][]chessImage,
                                         int oldX, int oldY, int newX, int newY){
        if (oldX == 6) {
            chessSquares[oldX][oldY].setName("King_Black");
            chessSquares[oldX][oldY].setIcon(new ImageIcon(chessImage[0][0]));
            chessSquares[oldX - 2][oldY].setName("Null");
            chessSquares[oldX - 2][oldY].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("Bishop_Black");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][2]));
            chessSquares[7][0].setName("Null");
            chessSquares[7][0].setIcon(new ImageIcon());
        } else if(oldX == 2){
            chessSquares[oldX][oldY].setName("King_Black");
            chessSquares[oldX][oldY].setIcon(new ImageIcon(chessImage[0][0]));
            chessSquares[oldX + 2][oldY].setName("Null");
            chessSquares[oldX + 2][oldY].setIcon(new ImageIcon());
            chessSquares[newX][newY].setName("Bishop_Black");
            chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][2]));
            chessSquares[0][0].setName("Null");
            chessSquares[0][0].setIcon(new ImageIcon());
        }
    }
}
