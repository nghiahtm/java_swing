package org.example.usecase;
import org.example.db.BookDB;
import org.example.interfaces.IBook;
import org.example.models.BookModel;
import org.example.models.DetailBookModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookUseCase implements IBook {
    private BookDB db;
    public BookUseCase(){
        db = BookDB.getInstance();
    }

    @Override
    public boolean isSuccessAddBook(BookModel book) {
        return db.isAddSuccessBook(book);
    }

    @Override
    public boolean editBook(DetailBookModel book) {
        BookModel bookEdited = new BookModel(
                book.getName(),
                book.getInsbCode(),
                book.getBookTitle(),
                book.getYearPublish(),
                book.getPublisher().id,
                book.getGenre().id,
                book.getAuthorModel().getId(),
                book.getIDBook(),
                book.getSellPricing()
        );
       return db.isEditSuccess(bookEdited);
    }

    @Override
    public boolean removeBook(int id) {
        return db.isRemoveBook(id);
    }

    @Override
    public List<DetailBookModel> getBooks() {
        final List<DetailBookModel> books = db.getBook();
        return Objects.requireNonNullElseGet(books, () -> new ArrayList<>(0));
    }

    @Override
    public boolean isISNBExist(String insb) {
        return db.isINSBExistInDb(insb);
    }

    @Override
    public void clearAllBooks() {

    }
}
