package org.example.presentations;

import org.example.presentations.AuthorScreen.AuthorFrame;
import org.example.presentations.BookScreen.BookFrame;
import org.example.presentations.GenreScreen.GenreForm;
import org.example.presentations.PublisherScreen.PublisherForm;
import org.example.presentations.PublisherScreen.PublisherScreen;

import javax.swing.*;

public class StartApp {
    static public void startApp() {
        JFrame jFrame = new JFrame();
        jFrame.setContentPane(new PublisherForm().publisherPanel);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
