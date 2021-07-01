package cz.cvut.fel.pjv.main;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;

import javax.swing.JButton;
import javax.swing.JFrame;

public class RestartCode {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton button = new JButton();
        button.setSize(100,100);
        button.setLocation(200,200);
        button.setVisible(true);
        frame.add(button);
        frame.setSize(400, 400);
        frame.setVisible(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("HO");

                StringBuilder cmd = new StringBuilder();
                cmd.append(System.getProperty("java.home") + File.separator + "bin" + File.separator + "java ");
                for (String jvmArg : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
                        cmd.append(jvmArg + " ");
                    }

                cmd.append("-cp ").append(ManagementFactory.getRuntimeMXBean().getClassPath()).append(" ");
                cmd.append(Window.class.getName()).append(" ");

                try
                {
                    Runtime.getRuntime().exec(cmd.toString());
                }
                catch (IOException e1)
                {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                System.exit(0);
            }
        });

    }

}
