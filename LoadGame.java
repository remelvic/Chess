package cz.cvut.fel.pjv.main;

import cz.cvut.fel.pjv.main.black.*;
import cz.cvut.fel.pjv.main.white.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * Load the game that is saved in a .txt file or in a .png format
 */
public class LoadGame {
    PawnWhite pw = new PawnWhite();
    PawnBlack pb = new PawnBlack();
    KnightBlack nb = new KnightBlack();
    KnightWhite nw = new KnightWhite();
    BishopWhite bw = new BishopWhite();
    BishopBlack bb = new BishopBlack();
    RookWhite rw = new RookWhite();
    RookBlack rb = new RookBlack();
    QueenBlack qb = new QueenBlack();
    QueenWhite qw = new QueenWhite();
    KingWhite kw = new KingWhite();
    KingBlack kb = new KingBlack();

    char [] RowLetter={'a','b','c','d','e','f','g','h'};
    char [] NumberColumn={'8','7','6','5','4','3','2','1'};
    int y;
    int x;
    String  data;
    int count = 0;

    /**
     *Loading a saved game. I go through the array of saved moves and refer
     * to the pieces that I moved
     * @param message Writes to the toolbar that the game has been saved
     * @param chessSquares an array of all buttons (squares)
     * @param chessImage an array of all pieces
     * @param ROW The array with which I choose which shapes to put on the board
     * @throws IOException
     */
    public final void LoadGame(JLabel message, JButton[][] chessSquares,
                               Image[][] chessImage, int [] ROW)
            throws IOException {
        message.setText("Game loaded successfully");
        File file = new File("Game.pgn");

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        data  = br.readLine();
        //get data
        System.out.println(data);

        startGame(chessSquares,chessImage,ROW);
        //replace number of move
        for (int i = 1; i < 12; i++) {
            data = data.replace(i+".", "");
        }
        //add newData to array
        String[] newData = data.split(" ");
        for (int i = 0; i < newData.length; i++) {
            if(newData[i].equals("")) newData[i] = null;
        }

        for (int i = 0; i < newData.length; i++) {

            if (newData[i] != null) {
                count++;
                if (newData[i].length() == 2) {
                    y = new String(NumberColumn).indexOf(newData[i].charAt(1));
                    x = new String(RowLetter).indexOf(newData[i].charAt(0));


                    if (i % 2 == 0 && i == 2){
                        pb.PawnBlackForLoad(chessSquares,chessImage, x,y-2,x,y);
                    }else if (count % 2 == 0){
                        pb.PawnBlackForLoad(chessSquares,chessImage, x,y-1,x,y);
                    }
                    if(i % 2 != 0 && i == 1){
                        pw.PawnWhiteForLoad(chessSquares,chessImage, x, y+2,x,y);
                    }else if (count % 2 != 0){
                        pw.PawnWhiteForLoad(chessSquares,chessImage, x,y+1,x,y);
                    }
                    //Pawn
                } else if(newData[i].length() == 4 && (newData[i].contains("x")
                        && !newData[i].contains("R") && !newData[i].contains("N")
                        && !newData[i].contains("K") && !newData[i].contains("B")
                        && !newData[i].contains("Q"))){

                    y = new String(NumberColumn).indexOf(newData[i].charAt(3));
                    x = new String(RowLetter).indexOf(newData[i].charAt(2));

                    int oldX = new String(RowLetter).indexOf(newData[i].charAt(0));

                    if(count % 2 != 0){
                        pw.PawnWhiteForLoad(chessSquares,chessImage, oldX,y+1,x,y);
                    }else if (count % 2 == 0){
                        pb.PawnBlackForLoad(chessSquares,chessImage, oldX,y-1,x,y);
                    }
                    //Pawn attack
                }else if(newData[i].length() == 4 && newData[i].contains("=")){
                    //Pawn transform
                }else if(newData[i].length() == 3 && newData[i].contains("N")){
                    y = new String(NumberColumn).indexOf(newData[i].charAt(2));
                    x = new String(RowLetter).indexOf(newData[i].charAt(1));
                    if(count%2 != 0){

                        nw.KnightWhiteForLoad(chessSquares,chessImage,x,y,x,y);
                    }else if (count%2 == 0){
                        nb.KnightBlackForLoad(chessSquares,chessImage,x,y,x,y);
                    }
                    //Knight
                }else if(newData[i].length() == 4 && newData[i].contains("Nx")){
                    y = new String(NumberColumn).indexOf(newData[i].charAt(3));
                    x = new String(RowLetter).indexOf(newData[i].charAt(2));

                    if(count % 2 != 0){
                        //System.out.println(newData[i]+"KONXXXX");
                        nw.KnightWhiteForLoad(chessSquares,chessImage,x,y,x,y);
                    }else if (count % 2 == 0){
                        nb.KnightBlackForLoad(chessSquares,chessImage,x,y,x,y);
                    }
                    //KnightAttack
                }else if(newData[i].length() == 3 && newData[i].contains("B")){
                    y = new String(NumberColumn).indexOf(newData[i].charAt(2));
                    x = new String(RowLetter).indexOf(newData[i].charAt(1));
                    if(count % 2 != 0){
                        bw.BishopWhiteForLoad(chessSquares,chessImage,x,y,x,y);
                    }else if (count % 2 == 0){
                        bb.BishoBlackForLoad(chessSquares,chessImage,x,y,x,y);
                    }
                    //Bishop
                }else if(newData[i].length() == 4 && newData[i].contains("Bx")){
                    y = new String(NumberColumn).indexOf(newData[i].charAt(3));
                    x = new String(RowLetter).indexOf(newData[i].charAt(2));
                    if(count % 2 != 0){
                        bw.BishopWhiteForLoad(chessSquares,chessImage,x,y,x,y);
                    }else if (count % 2 == 0){
                        bb.BishoBlackForLoad(chessSquares,chessImage,x,y,x,y);
                    }
                    //BishopAttack
                }else if(newData[i].length() == 3 && newData[i].contains("R")){
                    y = new String(NumberColumn).indexOf(newData[i].charAt(2));
                    x = new String(RowLetter).indexOf(newData[i].charAt(1));
                    if(count % 2 != 0){
                        rw.RookWhiteForLoad(chessSquares,chessImage,x,y,x,y);
                    }else if(count % 2 == 0) {
                        rb.RookBlackForLoad(chessSquares,chessImage,x,y,x,y);
                    }
                    //Rook
                }else if(newData[i].length() == 4 && newData[i].contains("Rx")){
                    y = new String(NumberColumn).indexOf(newData[i].charAt(3));
                    x = new String(RowLetter).indexOf(newData[i].charAt(2));
                    if(count % 2 != 0){
                        rw.RookWhiteForLoad(chessSquares,chessImage,x,y,x,y);
                    }else if (count % 2 == 0){
                        rb.RookBlackForLoad(chessSquares,chessImage,x,y,x,y);
                    }
                    //RookAttack
                }else if(newData[i].length() == 3 && newData[i].contains("Q")){
                    y = new String(NumberColumn).indexOf(newData[i].charAt(2));
                    x = new String(RowLetter).indexOf(newData[i].charAt(1));
                    if(count % 2 != 0){
                        qw.QueenWhiteForLoad(chessSquares,chessImage,x,y,x,y);
                    }else if (count % 2 == 0){
                        qb.QueenBlackForLoad(chessSquares,chessImage,x,y,x,y);
                    }
                    //Queen
                }else if(newData[i].length() == 4 && newData[i].contains("Qx")){
                    y = new String(NumberColumn).indexOf(newData[i].charAt(3));
                    x = new String(RowLetter).indexOf(newData[i].charAt(2));
                    if(count % 2 != 0){
                        qw.QueenWhiteForLoad(chessSquares,chessImage,x,y,x,y);
                    }else if (count % 2 == 0){
                        qb.QueenBlackForLoad(chessSquares,chessImage,x,y,x,y);
                    }
                    //QueenAttack
                }else if(newData[i].length() == 3 && newData[i].contains("K")){
                    y = new String(NumberColumn).indexOf(newData[i].charAt(2));
                    x = new String(RowLetter).indexOf(newData[i].charAt(1));
                    if(count % 2 != 0){
                        kw.KingWhiteForLoad(chessSquares,chessImage,x,y,x,y);
                    }else if (count % 2 == 0){
                        kb.KingBlackForLoad(chessSquares,chessImage,x,y,x,y);
                    }
                    //King
                }else if(newData[i].length() == 4 && newData[i].contains("Kx")){
                    y = new String(NumberColumn).indexOf(newData[i].charAt(3));
                    x = new String(RowLetter).indexOf(newData[i].charAt(2));
                    if(count % 2 != 0){
                        kw.KingWhiteForLoad(chessSquares,chessImage,x,y,x,y);
                    }else if (count % 2 == 0){
                        kb.KingBlackForLoad(chessSquares,chessImage,x,y,x,y);
                    }
                    //KingAttack
                }else if(newData[i].length() == 3 && newData[i].contains("-")){
                    if (count % 2 != 0) {
                        int yForKing = new String(NumberColumn).indexOf("1");
                        int xForKing = new String(RowLetter).indexOf("g");
                        y = new String(NumberColumn).indexOf("1");
                        x = new String(RowLetter).indexOf("f");
                        kw.KingWhiteForLoadCastling(chessSquares,chessImage,xForKing,yForKing,x,y);
                    }else if(count % 2 == 0){
                        int yForKing = new String(NumberColumn).indexOf("8");
                        int xForKing = new String(RowLetter).indexOf("g");
                        y = new String(NumberColumn).indexOf("8");
                        x = new String(RowLetter).indexOf("f");
                        kb.KingBlackForLoadCastling(chessSquares,chessImage,xForKing,yForKing,x,y);
                    }

                    //Castling Short
                }else if(newData[i].length() == 5 && newData[i].contains("-")){
                    if (count % 2 != 0) {
                        int yForKing = new String(NumberColumn).indexOf("1");
                        int xForKing = new String(RowLetter).indexOf("c");
                        y = new String(NumberColumn).indexOf("1");
                        x = new String(RowLetter).indexOf("d");

                        kw.KingWhiteForLoadCastling(chessSquares, chessImage, xForKing, yForKing, x, y);
                    }else if(count % 2 == 0){
                        int yForKing = new String(NumberColumn).indexOf("8");
                        int xForKing = new String(RowLetter).indexOf("c");
                        y = new String(NumberColumn).indexOf("8");
                        x = new String(RowLetter).indexOf("d");

                        kb.KingBlackForLoadCastling(chessSquares, chessImage, xForKing, yForKing, x, y);
                    }
                    //Castling Long
                }else if(newData[i].length() == 4 && newData[i].contains("#")){
                    //MAT
                }
            }
        }
        System.out.println(data);
    }

    /**
     * Restart the game to play the saved game
     * @param chessSquares an array of all buttons (squares)
     * @param chessImage an array of all pieces
     * @param ROW The array with which I choose which shapes to put on the board
     */
    public void startGame(JButton[][] chessSquares,
                          Image[][] chessImage, int[] ROW){
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
