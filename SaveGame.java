package cz.cvut.fel.pjv.main;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * I use to save the game in png format
 */
public class SaveGame {
    static Logger log = Logger.getLogger(SaveGame.class.getName());

    /**
     * I open the pgn file and save the textGame array to it
     * @param message Write in the toolbar that the game is saved
     * @param textGame The resulting array with the history of moves
     * @throws IOException
     */
    public final void saveGame(JLabel message,ArrayList<String> textGame)
            throws IOException {
        int j = 0;
        message.setText("Game saved!");
        File file = new File("Game.pgn");
        if(file.createNewFile()){
            log.info("File created: "+file.getName());
        } else{
            log.info("File already exists: "+file.getName());
        }

        System.out.println("file to save:"+file);
        FileWriter mw = new FileWriter(file);
        for (int i = 1; i < textGame.size(); i+=2, j++) {
            mw.write(""+(j+1)+". "+textGame.get(i-1)+" "+textGame.get(i)+" ");
        }
        mw.close();
    }

    public final void saveGame(ArrayList<String> textGame) throws IOException {
        int j = 0;
        File file = new File("Game.pgn");
        if(file.createNewFile()){
            log.info("File created: "+file.getName());
        } else{
            log.info("File already exists: "+file.getName());
        }

        System.out.println("file to save:"+file);
        FileWriter mw = new FileWriter(file);
        for (int i = 1; i < textGame.size(); i+=2, j++) {
            mw.write(""+(j+1)+". "+textGame.get(i-1)+" "+textGame.get(i)+" ");
        }
        mw.close();
    }
}
