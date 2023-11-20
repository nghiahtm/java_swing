package org.example.presentations;

import org.example.presentations.BookScreen.BookFrame;
import javax.swing.*;

public class StartApp {
    static public void startApp() {
        JFrame jFrame = new JFrame();
        jFrame.setContentPane(new BookFrame().bookPanel);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
