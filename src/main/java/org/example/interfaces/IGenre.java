package org.example.interfaces;

import org.example.models.GenreModel;

import java.util.List;

public interface IGenre {
    public boolean isSuccessAddGenre(GenreModel genre);
    public boolean isSuccessEditGenre(GenreModel genre);
    public boolean isSuccessRemoveGenre(int id);
    public List<GenreModel> getGenres();
}
