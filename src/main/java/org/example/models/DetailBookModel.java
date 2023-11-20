package org.example.models;
import org.example.common.ConnectionString;

import java.sql.ResultSet;

public class DetailBookModel {
    private final String name;
    private final String bookTitle;
    private final String publisher;
    private final String authorName;
    private final String genre;
    private final int sellPricing;
    private final int yearPublish;
    private final Integer idBook;
    private final String insbCode;


    public String getName() {
        return name;
    }

    public String getBookTitle() {
        return bookTitle;
    }
    public String getInsbCode() {
        return insbCode;
    }
    public String getPublisher() {
        return publisher;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getSellPricing() {
        return sellPricing;
    }

    public String getGenre() {
        return genre;
    }

    public String insbCode() {
        return insbCode;
    }
    public int getYearPublish() {
        return yearPublish;
    }
    public int getIDBook() {
        return idBook;
    }

    //    private final String genre;

    public DetailBookModel(
                     String name, String title,
                     int sellPricing,
                     String insbCode,
                     String publisher,
                     int yearPublish,
                    String genre,
                      String authorName,
                     int idBook) {
        this.name = name;
        this.bookTitle = title;
        this.genre = genre;
        this.yearPublish = yearPublish;
        this.sellPricing = sellPricing;
        this.publisher = publisher;
        this.insbCode = insbCode;
        this.authorName = authorName;
        this.idBook = idBook;
    }


    public static DetailBookModel parseBookData(ResultSet rs){
        int idBook = ConnectionString.parseIntMySQL(rs,"id_book");
        String name = ConnectionString.parseStringMySQL(rs,"book_name");
        String title = ConnectionString.parseStringMySQL(rs,"book_title");
        String authorName = ConnectionString.parseStringMySQL(rs,"author_name");
        String genre = ConnectionString.parseStringMySQL(rs,"genre");
        String insbCode = ConnectionString.parseStringMySQL(rs,"insb_code");
        String publisher = ConnectionString.parseStringMySQL(rs,"publisher");
        int sellPrice = ConnectionString.parseIntMySQL(rs,"selling_price");
        int publishYear = ConnectionString.parseIntMySQL(rs,"publish_year");
        return new DetailBookModel(
                name,
                title,
                sellPrice,
                insbCode,
                publisher,
                publishYear,
                genre,
                authorName,
                idBook);
    }
}
