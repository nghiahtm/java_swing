package org.example;

import org.example.config.ConnectorDB;
import org.example.db.AuthorDB;
import org.example.db.BookDB;
import org.example.db.GenreDB;
import org.example.db.PublisherDB;
import org.example.presentations.StartApp;

public class Main {
    public static void main(String[] args) {
        instance();
        StartApp.startApp();
    }

    private static void instance(){
        //DB
        ConnectorDB.getInstance();
        AuthorDB.getInstance();
        BookDB.getInstance();
        PublisherDB.getInstance();
        GenreDB.getInstance();
    }
}