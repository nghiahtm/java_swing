package org.example.interfaces;
import org.example.models.BookModel;
import org.example.models.DetailBookModel;

import java.util.List;

public interface IBook {
    public boolean isSuccessAddBook(BookModel book);
    public boolean editBook(BookModel book);
    public boolean removeBook(int id);
    public List<DetailBookModel> getBooks();
    public boolean isISNBExist(String insb);
    public void clearAllBooks();
}
