package cz.cvut.fel.pjv.main;

import cz.cvut.fel.pjv.main.black.*;
import cz.cvut.fel.pjv.main.white.*;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *In the Logic class, I choose where the figure will go and which figure will move.
 */
public class Logic{
    int xLast;
    int yLast;
    int move;

    PawnWhite pw = new PawnWhite();
    PawnBlack pb = new PawnBlack();
    RookBlack rb = new RookBlack();
    RookWhite rw = new RookWhite();
    KnightBlack knb = new KnightBlack();
    KnightWhite knw = new KnightWhite();
    BishopWhite bw = new BishopWhite();
    BishopBlack bb = new BishopBlack();
    QueenWhite qw = new QueenWhite();
    QueenBlack qb = new QueenBlack();
    KingWhite kw = new KingWhite();
    KingBlack kb = new KingBlack();
    static Logger log = Logger.getLogger(Logic.class.getName());

    /**
     * If the player chooses the wrong move, an error window pops up
     */
    public static void errorMove() {
        JOptionPane.showMessageDialog(null, "Wrong Move", "Error",JOptionPane.ERROR_MESSAGE);

    }

    /**
     * The Logic function determines from which coordinates the figure comes and
     * which figure it will be.
     * @param chessSquares an array of all buttons (squares)
     * @param chessImage an array of all pieces
     * @param i determines the size of the array in x
     * @param j determines the size of the array in y
     * @param myX X-coordinates where the figure is going
     * @param myY Y-coordinates where the figure is going
     * @param width of one square is used to move shapes in X
     * @param height of one square is used to move shapes in Y
     * @param figureOpponent contains the name of the square that we chose where
     *                      we will go
     * @param textGame Will contain the whole game in pgn format
     */
    public void Logic(JButton[][] chessSquares, Image[][] chessImage, int i,
                      int j, int myX, int myY, int width, int height,
                      String figureOpponent, ArrayList<String>
                              textGame){
        chessSquares[i][j].addMouseListener(new BasicButtonListener(new JButton()));

        chessSquares[i][j].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                yLast = ((JButton) e.getSource()).getLocationOnScreen().y;
                xLast = ((JButton) e.getSource()).getLocationOnScreen().x;

                log.info("From where y "+yLast+" x "+xLast);


                if (e.getButton() == 1 && e.getClickCount() == 2){

                    log.info("Selected figure "+
                            chessSquares[i][j].getName());

                    if (chessSquares[i][j].getName().contains("PawnWhite") && move == 0) {
                        pw.PawnWhite(chessSquares, chessImage,myX,myY,
                                xLast,yLast,i,j,height, width, figureOpponent,
                                textGame);

                        move = pw.getMove();


                    } else if (chessSquares[i][j].getName().
                            contains("PawnBlack") && move != 0) {
                        pb.PawnBlack(chessSquares, chessImage, myX, myY, xLast,
                                yLast, i,j,height,width,figureOpponent,
                                textGame);

                        move = pb.getMove();


                    } else if (chessSquares[i][j].getName().
                            equals("Rook_Black") && move != 0) {
                        rb.RookBlack(chessSquares, chessImage, myX, myY, xLast,
                                yLast, i,j,height,width,figureOpponent,
                                textGame);


                        move = rb.getMove();


                    } else if (chessSquares[i][j].getName().
                            equals("Rook_White") && move == 0){
                        rw.RookWhite(chessSquares, chessImage, myX, myY, xLast,
                                yLast, i,j,height,width,figureOpponent,
                                textGame);


                        move = rw.getMove();

                    } else if (chessSquares[i][j].getName().
                            equals("Knight_Black") && move != 0){
                        knb.KnightBlack(chessSquares, chessImage, myX, myY, xLast,
                                yLast, i,j,height,width,figureOpponent,
                                textGame);


                        move = knb.getMove();

                    } else if (chessSquares[i][j].getName().
                            equals("Knight_White") && move == 0){
                        knw.KnightWhite(chessSquares, chessImage, myX, myY, xLast,
                                yLast, i,j,height,width,figureOpponent,
                                textGame);


                        move = knw.getMove();

                    } else if (chessSquares[i][j].getName().
                            equals("Bishop_Black") && move != 0){
                        bb.BishopBlack(chessSquares, chessImage, myX, myY, xLast,
                                yLast, i,j,height,width,figureOpponent,
                                textGame);


                        move = bb.getMove();

                    } else if (chessSquares[i][j].getName().
                            equals("Bishop_White") && move == 0){
                        bw.BishopWhite(chessSquares, chessImage, myX, myY, xLast,
                                yLast, i,j,height,width,figureOpponent,
                                textGame);


                        move = bw.getMove();

                    } else if (chessSquares[i][j].getName().
                            equals("Queen_Black") && move != 0){
                        qb.QueenBlack(chessSquares, chessImage, myX, myY, xLast,
                                yLast, i,j,height,width,figureOpponent,
                                textGame);

                        move = qb.getMove();

                    } else if (chessSquares[i][j].getName().
                            equals("Queen_White") && move == 0){
                        qw.QueenWhite(chessSquares, chessImage, myX, myY, xLast,
                                yLast, i,j,height,width,figureOpponent,
                                textGame);

                        move = qw.getMove();

                    } else if (chessSquares[i][j].getName().
                            equals("King_Black") && move != 0){
                        kb.KingBlack(chessSquares, chessImage, myX, myY, xLast,
                                yLast, i,j,height,width,figureOpponent,
                                textGame);

                        move = kb.getMove();

                    } else if (chessSquares[i][j].getName().
                            equals("King_White") && move == 0){
                        kw.KingWhite(chessSquares, chessImage, myX, myY, xLast,
                                yLast, i,j,height,width,figureOpponent,
                                textGame);

                        move = kw.getMove();


                    } else {
                        System.out.println(move);
                        System.out.println(chessSquares[i][j].getName());
                        System.out.println("now is the opponent's turn");
                    }
                }
                mouseExited(e);

            }


        });


    }

}
