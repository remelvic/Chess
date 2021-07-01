package cz.cvut.fel.pjv.main.black;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Logger;


/**
 * The BishopBlack class executes the black Bishop figure
 */
public class BishopBlack {
    //static Logger log = Logger.getLogger(BishopBlack.class.getName());
    boolean ret;
    String [] RowLetter={"a","b","c","d","e","f","g","h"};
    String [] NumberColumn={"8","7","6","5","4","3","2","1"};
    int move;

    /**
     * The BishopBlack function selects how the shape will go and moves it.If
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
    public synchronized void BishopBlack(JButton[][] chessSquares, Image[][]chessImage,
                            int myX, int myY, int xLast, int yLast, int i, int j,
                            int height, int width, String figureOpponent,
                            ArrayList<String> textGame){

        move = 1;
        ret = false;
        for (int k = 1; k < 8; k++) {
          //Right down OK
            if(myX - (width*k) == xLast && myY - (height*k) == yLast &&
                    (figureOpponent.equals("Null") ||
                            figureOpponent.contains("White")) &&
                !chessSquares[i+k][j+k].getName().contains("Black")){

                for (int z = 1; z < k; ++z){
                    if(!chessSquares[i+z][j+z].getName().contains("Null")){
                        JOptionPane.showMessageDialog(null,
                                "Error Move",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                //log.info("Right down Bishop Black");
                chessSquares[i + k][j + k].setName("Bishop_Black");
                chessSquares[i + k][j + k].setIcon(new ImageIcon(
                        chessImage[0][4]));
                chessSquares[i][j].setName("Null");
                chessSquares[i][j].setIcon(new ImageIcon());

                if(figureOpponent.contains("White")){
                    textGame.add("Bx"+RowLetter[i+k]+NumberColumn[j+k]);
                } else{
                    textGame.add("B"+RowLetter[i+k]+NumberColumn[j+k]);
                }
                
                move = 0;


                //Right up
            }else if (myX - (width*k) == xLast && myY + (height*k) == yLast &&
                    (figureOpponent.equals("Null") ||
                            figureOpponent.contains("White")) &&
                    !chessSquares[i+k][j-k].getName().contains("Black")){

                for (int z = 1; z < k; ++z){
                    if(!chessSquares[i+z][j-z].getName().contains("Null")){
                        JOptionPane.showMessageDialog(null,
                                "Error Move",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                //log.info("Right UP Bishop Black");
                chessSquares[i + k][j - k].setName("Bishop_Black");
                chessSquares[i + k][j - k].setIcon(new ImageIcon(
                        chessImage[0][4]));
                chessSquares[i][j].setName("Null");
                chessSquares[i][j].setIcon(new ImageIcon());

                if(figureOpponent.contains("White")){
                    textGame.add("Bx"+RowLetter[i+k]+NumberColumn[j-k]);
                } else{
                    textGame.add("B"+RowLetter[i+k]+NumberColumn[j-k]);
                }
                
                move = 0;



                //Left down
            } else if (myX+(width*k) == xLast && myY-(height*k) == yLast &&
                    (figureOpponent.equals("Null") ||
                            figureOpponent.contains("White")) &&
                    !chessSquares[i-k][j+k].getName().contains("Black")){

                for (int z = 1; z < k; ++z){
                    if(!chessSquares[i-z][j+z].getName().contains("Null")){
                        JOptionPane.showMessageDialog(null,
                                "Error Move",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                //log.info("LEFT DOWN Bishop Black");
                chessSquares[i - k][j + k].setName("Bishop_Black");
                chessSquares[i - k][j + k].setIcon(new ImageIcon(
                        chessImage[0][4]));
                chessSquares[i][j].setName("Null");
                chessSquares[i][j].setIcon(new ImageIcon());

                if(figureOpponent.contains("White")){
                    textGame.add("Bx"+RowLetter[i-k]+NumberColumn[j+k]);
                } else{
                    textGame.add("B"+RowLetter[i-k]+NumberColumn[j+k]);
                }
                
                move = 0;



                //Left up OK
            } else if(myX+(width*k) == xLast && myY+(height*k) == yLast &&
                    (figureOpponent.equals("Null") ||
                            figureOpponent.contains("White")) &&
                    !chessSquares[i-k][i-k].getName().contains("Black")){

                for (int z = 1; z < k; ++z){
                    if(!chessSquares[i-z][j-z].getName().contains("Null")){
                        JOptionPane.showMessageDialog(null,
                                "Error Move",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                //log.info("LEFT UP Bishop Black");
                chessSquares[i - k][j - k].setName("Bishop_Black");
                chessSquares[i - k][j - k].setIcon(new ImageIcon(
                        chessImage[0][4]));
                chessSquares[i][j].setName("Null");
                chessSquares[i][j].setIcon(new ImageIcon());

                if(figureOpponent.contains("White")){
                    textGame.add("Bx"+RowLetter[i-k]+NumberColumn[j-k]);
                } else{
                    textGame.add("B"+RowLetter[i-k]+NumberColumn[j-k]);
                }
                
                move = 0;

            }
        }

    }

    public int getMove() {
        return move;
    }
    public void BishoBlackForLoad(JButton[][] chessSquares, Image[][]chessImage,
                                  int oldX, int oldY, int newX, int newY){
        for (int i = 0; i < 8; i++) {
            //try {
                if (chessSquares[oldX + i][oldY + i].getName().equals("Bishop_Black")) {
                    chessSquares[oldX + i][oldY + i].setName("Null");
                    chessSquares[oldX + i][oldY + i].setIcon(new ImageIcon());
                    chessSquares[newX][newY].setName("Bishop_Black");
                    chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][4]));

                } else if (chessSquares[oldX + i][oldY - i].getName().equals("Bishop_Black")) {
                    chessSquares[oldX + i][oldY - i].setName("Null");
                    chessSquares[oldX + i][oldY - i].setIcon(new ImageIcon());
                    chessSquares[newX][newY].setName("Bishop_Black");
                    chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][4]));

                } else if (chessSquares[oldX - i][oldY + i].getName().equals("Bishop_Black")) {
                    chessSquares[oldX - i][oldY + i].setName("Null");
                    chessSquares[oldX - i][oldY + i].setIcon(new ImageIcon());
                    chessSquares[newX][newY].setName("Bishop_Black");
                    chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][4]));

                } else if (chessSquares[oldX - i][oldY - i].getName().equals("Bishop_Black")) {
                    chessSquares[oldX - i][oldY - i].setName("Null");
                    chessSquares[oldX - i][oldY - i].setIcon(new ImageIcon());
                    chessSquares[newX][newY].setName("Bishop_Black");
                    chessSquares[newX][newY].setIcon(new ImageIcon(chessImage[0][4]));
                }
            //}catch (ArrayIndexOutOfBoundsException e){
            //    System.out.println("aha");//break;
            //}
        }
    }

}
