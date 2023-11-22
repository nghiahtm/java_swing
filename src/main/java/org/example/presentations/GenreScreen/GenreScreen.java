package org.example.presentations.GenreScreen;


import org.example.presentations.AuthorScreen.AuthorFrame;

import javax.swing.*;

public class GenreScreen extends JFrame{
    public GenreScreen() {
        this.setContentPane(new GenreForm().genrePanel);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(false);
    }
}

