package org.example.interfaces;

import org.example.models.AuthorModel;

import java.util.List;

public interface IAuthor {
    public boolean isSuccessAddAuthor(AuthorModel author);
    public boolean isSuccessEditAuthor(AuthorModel author);
    public boolean isSuccessRemoveAuthor(int id);
    public List<AuthorModel> getAuthors();
}
