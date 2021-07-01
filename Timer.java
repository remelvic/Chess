package cz.cvut.fel.pjv.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


/**
 * I use the timer to calculate the time between the players' moves
 */
public class Timer {
    int minute101 = 0;
    int minute1 = 0;
    int second101 = 0;
    int second1 = 0;
    int minute10 = 0;
    int minute = 0;
    int second10 = 0;
    int second = 0;
    int click = 0;
    int click2 = 0;
    JLabel time1 = new JLabel();
    JLabel time2 = new JLabel();
    Thread th = new Thread(new Runnable() {
        @Override
        public void run() {


            while (true) {
                click = 1;
                second1 += 1;
                System.out.println("FIRST: "+minute101 + "" + minute1 + ":" + second101 + "" + second1);
                time1.setText("FIRST: "+minute101 + "" + minute1 + ":" + second101 + "" + second1);
                time1.setFont(new Font("Ariel",Font.BOLD,30));
                if (second1 == 9 && second101 != 5) {
                    second1 = -1;
                    second101 += 1;
                }
                if (second101 == 5 && second1 == 9) {
                    second1 = -1;
                    second101 = 0;
                    minute1 += 1;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });
    Thread th1 = new Thread(new Runnable() {
        @Override
        public void run() {

            while (true) {
                click = 0;
                click2 = -1;
                second += 1;
                System.out.println(("SECOND: "+minute10 + "" + minute + ":" + second10 + "" + second));
                time2.setText("SECOND: "+minute10 + "" + minute + ":" + second10 + "" + second);
                time2.setFont(new Font("Ariel",Font.BOLD,30));
                if (second == 9 && second10 != 5) {
                    second = -1;
                    second10 += 1;
                }
                if (second10 == 5 && second == 9) {
                    second = -1;
                    second10 = 0;
                    minute += 1;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });


    public void mainTimer(JLabel message){
        message.setText("Timer started");
        //JFrame jf = new JFrame("Timer");
        JPanel mainPanel = new JPanel();

        JButton jb = new JButton("Switch");
        JFrame jf = new JFrame("Timer");

        //th.start();
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Switched");
                if(click == 0 && click2 == 0){
                    th.start();
                    if(click == 0 && click2 == -1){

                        th.run();

                        th1.suspend();
                    }

                }
                if (click !=0) {

                    th1.resume();
                    th.suspend();

                }
            }
        });
        mainPanel.setLayout(new GridLayout(2,2));
        mainPanel.add(time1);
        mainPanel.add(time2);
        mainPanel.add(jb);
        jf.setLayout(new FlowLayout());
        jf.add(mainPanel, BorderLayout.NORTH);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jf.setSize(500,400);
        jf.setVisible(true);
    }


}
