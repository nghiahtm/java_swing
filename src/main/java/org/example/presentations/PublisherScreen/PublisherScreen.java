package org.example.presentations.PublisherScreen;

import org.example.presentations.GenreScreen.GenreForm;
import org.example.usecase.PublisherUseCase;

import javax.swing.*;

public class PublisherScreen extends JFrame {
    public PublisherScreen() {
        this.setContentPane(new PublisherForm().publisherPanel);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(false);
    }
}
