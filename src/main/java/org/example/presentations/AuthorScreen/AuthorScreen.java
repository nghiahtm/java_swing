package org.example.presentations.AuthorScreen;

import javax.swing.*;

public class AuthorScreen extends JFrame{
    public AuthorScreen() {
        this.setContentPane(new AuthorFrame().panelAuthor);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(false);
    }
}

