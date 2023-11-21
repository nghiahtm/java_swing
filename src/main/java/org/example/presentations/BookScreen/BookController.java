package org.example.presentations.BookScreen;

import org.example.models.*;
import org.example.usecase.AuthorUseCase;
import org.example.usecase.BookUseCase;
import org.example.usecase.GenreUseCase;
import org.example.usecase.PublisherUseCase;

import java.util.List;

public class BookController {
    final private BookUseCase bookUseCase;
    final private AuthorUseCase authorUseCase;
    final private PublisherUseCase publisherUseCase;
    final private GenreUseCase genreUseCase;

    public List<DetailBookModel> books;
    public DetailBookModel bookSelected;


    public BookController(){
        bookUseCase = new BookUseCase();
        authorUseCase = new AuthorUseCase();
        publisherUseCase = new PublisherUseCase();
        genreUseCase = new GenreUseCase();
    }


    public List<DetailBookModel> getBooks(){
        return bookUseCase.getBooks();
    }
    public List<AuthorModel> getAuthors(){
        return authorUseCase.getAuthors();
    }

    public void getSelectedBook(int index) {
        bookSelected = books.get(index);
    }

    public boolean addBook(BookModel book) {
        return bookUseCase.isSuccessAddBook(book);
    }
    public boolean editBook(BookModel newBook) {
        return bookUseCase.editBook(newBook);
    }

    public boolean removeBook(int id) {
        return bookUseCase.removeBook(id);
    }
    public boolean isINSBExist(String insb) {
        return bookUseCase.isISNBExist(insb);
    }

    public List<PublisherModel> getPublishers(){
        return publisherUseCase.getPublishers();
    }
    public List<GenreModel> getGenres(){
        return genreUseCase.getGenres();
    }
}
