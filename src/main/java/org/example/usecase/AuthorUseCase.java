package org.example.usecase;

import org.example.db.AuthorDB;
import org.example.interfaces.IAuthor;
import org.example.models.AuthorModel;
import org.example.interfaces.IAuthor;
import org.example.models.GenreModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AuthorUseCase implements IAuthor {
    private AuthorDB db;
    public AuthorUseCase(){
        db = AuthorDB.getInstance();
    }

    @Override
    public boolean isSuccessAddAuthor(AuthorModel author) {
        return  db.isAddAuthorSuccess(author);
    }

    @Override
    public boolean isSuccessEditAuthor(AuthorModel author) {
        return false;
    }

    @Override
    public boolean isSuccessRemoveAuthor(int id) {
        return false;
    }

    @Override
    public List<AuthorModel> getAuthors() {
        return new ArrayList<>(db.getAuthors());
    }
}
