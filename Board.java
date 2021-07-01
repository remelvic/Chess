package cz.cvut.fel.pjv.main;

import cz.cvut.fel.pjv.main.black.KingBlack;
import cz.cvut.fel.pjv.main.white.KingWhite;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Used to create a board with swing.
 * The color of the chessboard I use from chess.com
 * Also, I place the figures here and the game is held here.
 * @author Remel Victor
 */

public class Board extends JFrame {
    Color white = new Color(240, 217,181);
    Color dark = new Color(181,136,99);
    Color background = new Color(227,183,117);

    public static final int[] ROW= {2,3,4,1,0,4,3,2};


    private JPanel window = new JPanel(new BorderLayout(3,3));
    private final JPanel board = new JPanel(new GridLayout(9, 9));
    private Image[][] chessImage = new Image[2][6];
    private JButton[][] chessSquares = new JButton[8][8];
    private final JLabel message = new JLabel("Ready to play!");
    private NewGame ng = new NewGame();
    private SaveGame sv = new SaveGame();
    private Move mv = new Move();
    private Restore rs = new Restore();
    private LoadGame lg = new LoadGame();
    private ArrayList<String> textGame = new ArrayList<>();
    int count = 0;
    KingBlack kb = new KingBlack();
    /**
     * The printLetters function prints letters on the very first line of the
     * board
     */
    private void printLetters(){
        board.add(new JLabel(""));
        for (int i = 0; i < 8; i++) {
            board.add(new JLabel("ABCDEFGH".substring(i,i+1),SwingConstants.CENTER));
        }
    }

    /**
     * The printLetters function prints numbers at the end of each line
     */
    private void printNumbersAndButton(){
        for (int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if (j == 0){
                    board.add(new JLabel("" +(9 - (i + 1)), SwingConstants.CENTER));
                }
                board.add(chessSquares[j][i]);
            }
        }
    }

    /**
    * Customize ToolBar with Save Game, Restore, New Game, Load Game buttons
    */
    private void optionsToolbar(){

        window.setBorder(new EmptyBorder(5,5,5,5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        window.add(tools, BorderLayout.PAGE_START);
        Action newGameAction = new AbstractAction("New") {
            @Override
            public void actionPerformed(ActionEvent e) {

                ng.NewGame(message, chessSquares, chessImage, ROW);
            }
        };
        tools.add(newGameAction);
        Action saveGameAction = new AbstractAction("Save") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sv.saveGame(message,textGame);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        };
        tools.add(saveGameAction);
        Action restoreGameAction = new AbstractAction("Restore") {
            @Override
            public void actionPerformed(ActionEvent e) {
                rs.restoreGame(message, e);
            }
        };
        tools.add(restoreGameAction);
        Action loadGameAction = new AbstractAction(" Load Game") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    lg.LoadGame(message, chessSquares, chessImage, ROW);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        };
        tools.add(loadGameAction);
        Action timerAction = new AbstractAction("Timer") {
            @Override
            public void actionPerformed(ActionEvent e) {
                TimerMaster timerOne = new TimerMaster("Timer White:");
                TimerMaster timerTwo = new TimerMaster("Timer Black:");
                JPanel mainPanel = new JPanel();
                JButton jb = new JButton("Switch");
                JFrame jf = new JFrame("Timer");
                timerOne.t.suspend();
                timerTwo.t.suspend();

                jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        count++;
                        System.out.println("Switched");
                        if (count % 2 != 0 && count == 1){

                            timerOne.t.suspend();
                        }else if(count % 2 == 0 && count == 2){
                            timerTwo.t.suspend();
                            timerOne.t.resume();
                        }else if (count % 2 != 0 && count != 1){
                            timerOne.t.suspend();
                            timerTwo.t.resume();
                        } else if (count % 2 == 0 && count != 2){
                            timerTwo.t.suspend();
                            timerOne.t.resume();
                        }
                    }
                });
                mainPanel.add(timerOne.time);
                mainPanel.add(timerTwo.time);
                mainPanel.add(jb);
                jf.add(mainPanel, BorderLayout.CENTER);
                jf.setSize(400,400);
                jf.setVisible(true);

            }
        };
        tools.add(timerAction);
        tools.addSeparator();
        tools.add(message);
    }


    /**
     * Board function adds squares, numbers and letters to the Window
     */
    public Board() {

        createImages();
        optionsToolbar();


        board.setBorder(new CompoundBorder(new EmptyBorder(8, 8, 8, 8), new LineBorder(Color.black)));

        board.setBackground(background);
        JPanel boardConstrain = new JPanel(new GridBagLayout());
        boardConstrain.setBackground(background);
        boardConstrain.add(board);
        window.add(boardConstrain);

        for (int i = 0; i < chessSquares.length; i++) {
            for (int j = 0; j < chessSquares.length; j++) {
                JButton button = new JButton();
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                button.setIcon(icon);

                if ((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0)) {
                    button.setBackground(white);
                } else {
                    button.setBackground(dark);
                }
                chessSquares[i][j] = button;
            }

        }
        printLetters();
        printNumbersAndButton();
        do {
            mv.move(chessSquares, chessImage, chessSquares.length, textGame);
        } while (kb.getShahOrMat());



    }
    /**
    * Processing the image, from where we will take the figures
    */
    private final void createImages() {
        File file = new File("D:\\khm\\Studium\\2.semestr\\PJV\\semestralka\\src\\cz\\cvut\\fel\\pjv\\main\\chess.png");
        try {
            BufferedImage img = ImageIO.read(file);
            for (int i = 0; i < 2; i++){
                for(int j = 0; j < 6;j++){
                    chessImage[i][j] = img.getSubimage(j*64,i*64,64, 64);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * The getWindow function returns the whole window in which the game will be
     */
    public final JComponent getWindow(){
        return window;
    }


}
