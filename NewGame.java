package cz.cvut.fel.pjv.main;

import javax.swing.*;
import java.awt.*;

/**
 *The NewGame class arranges the figures when the New game key is pressed which
 *  is located in the ToolBar
 */
public class NewGame {
   /**
    * The NewGame function places pieces on the chessboard.
    * Figures takes from the Row array
    * @param message Changes the message in the ToolBar
    * @param chessSquares an array of all buttons (squares)
    * @param chessImage an array of all pieces
    * @param ROW The array with which I choose which shapes to put on the board
    */
   public final void NewGame(JLabel message, JButton[][] chessSquares,
                             Image[][] chessImage, int[] ROW){

      message.setText("Play!");

      for (int i = 0; i < 8; i++) {
         //BlACK
         chessSquares[i][0].setIcon(new ImageIcon(chessImage[0][ROW[i]]));
         switch (i){
            case 0: chessSquares[0][0].setName("Rook_Black");
            case 1: chessSquares[1][0].setName("Knight_Black");
            case 2: chessSquares[2][0].setName("Bishop_Black");
            case 3: chessSquares[3][0].setName("Queen_Black");
            case 4: chessSquares[4][0].setName("King_Black");
            case 5: chessSquares[5][0].setName("Bishop_Black");
            case 6: chessSquares[6][0].setName("Knight_Black");
            case 7: chessSquares[7][0].setName("Rook_Black");
            default: break;
         }
      }
      //PAWN BLACK
      for (int i = 0; i < 8; i++){
         chessSquares[i][1].setIcon(new ImageIcon(chessImage[0][5]));
         chessSquares[i][1].setName("PawnBlack");
      }

      //PAWN WHITE
      for (int i = 0; i < 8; i++) {
         chessSquares[i][6].setIcon(new ImageIcon(chessImage[1][5]));
         chessSquares[i][6].setName("PawnWhite");
      }
      for (int i = 0; i < 8; i++) {
         //WHITE
         chessSquares[i][7].setIcon(new ImageIcon(chessImage[1][ROW[i]]));
         switch (i){
            case 0: chessSquares[0][7].setName("Rook_White");break;
            case 1: chessSquares[1][7].setName("Knight_White"); break;
            case 2: chessSquares[2][7].setName("Bishop_White"); break;
            case 3: chessSquares[3][7].setName("Queen_White"); break;
            case 4: chessSquares[4][7].setName("King_White"); break;
            case 5: chessSquares[5][7].setName("Bishop_White"); break;
            case 6: chessSquares[6][7].setName("Knight_White"); break;
            case 7: chessSquares[7][7].setName("Rook_White"); break;
            default: break;
         }
      }

      //EMPTY
      for(int i = 0; i < 8; i++){
         for (int j = 2; j < 6; j++) {
            chessSquares[i][j].setName("Null");
         }
      }
    }
}
