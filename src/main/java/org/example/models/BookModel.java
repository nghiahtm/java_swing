package org.example.models;

public class BookModel {
    final public String name;
    final public String isnb;
    final public String title;
    final public Integer publishYear;
    final public Integer idPublisher;
    final public Integer idGenre;
    final public Integer idAuthor;
    final public Integer idBook;
    final public Integer sellingPrice;

    public BookModel(String name, String isnb, String title, Integer publishYear, Integer idPublisher, Integer idGenre, Integer idAuthor, Integer idBook, Integer sellingPrice) {
        this.name = name;
        this.isnb = isnb;
        this.title = title;
        this.publishYear = publishYear;
        this.idPublisher = idPublisher;
        this.idGenre = idGenre;
        this.idAuthor = idAuthor;
        this.idBook = idBook;
        this.sellingPrice = sellingPrice;
    }
}
