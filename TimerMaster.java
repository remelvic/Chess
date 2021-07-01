package cz.cvut.fel.pjv.main;


import javax.swing.*;
import java.awt.*;

/**
 * My timer is implemented with two threads
 */
public class TimerMaster implements Runnable {

    public Thread t;
    public String procces;

    int minute101 = 0;
    int minute1 = 0;
    int second101 = 0;
    int second1 = 0;
    int count = 1;
    JLabel time = new JLabel();
    public TimerMaster(String procces) {
        t = new Thread(this);
        this.procces = procces;

        t.start();
    }

    /**
     * Increasing my timer
     */
    public void run(){
        try {

            while (true){
                second1 +=count;

                time.setText(procces + " "+minute101+""+minute1+":"+second101+""+second1);
                time.setFont(new Font("Ariel", Font.BOLD, 30));
                if (second1 == 9 && second101 != 5){
                    second1 = -1;
                    second101 +=1;
                }
                if (second101 == 5 && second1 == 9 && minute1 != 9){
                    second1 = -1;
                    second101 = 0;
                    minute1 +=1;
                }
                if (minute1 == 9 && second101 == 5 && second1 == 9 && minute101 != 5){
                    second1= -1;
                    second101 = 0;
                    minute1 = 0;
                    minute101 +=1;
                }
                if(minute101==5 && minute1 == 9 && second101 == 5 && second1 == 9){
                    t.stop();
                }
                long m = System.currentTimeMillis();
                Thread.sleep(1000);
                if ((System.currentTimeMillis() - m) > 2000 && m < 3000){
                    count = 2;
                }else{
                    count = 1;
                }
            }

        }catch (Exception ex){

        }
    }
}
