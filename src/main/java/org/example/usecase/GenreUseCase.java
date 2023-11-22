package org.example.usecase;

import org.example.db.BookDB;
import org.example.db.GenreDB;
import org.example.interfaces.IGenre;
import org.example.models.GenreModel;
import org.example.models.PublisherModel;

import java.util.ArrayList;
import java.util.List;

public class GenreUseCase implements IGenre {
    private GenreDB db;
    public GenreUseCase(){
        db = GenreDB.getInstance();
    }
    @Override
    public boolean isSuccessGenre(GenreModel genre) {
        return false;
    }

    @Override
    public boolean isSuccessEditGenre(GenreModel genre) {
        return false;
    }

    @Override
    public boolean isSuccessRemoveGenre(int id) {
        boolean isExist = db.isExistInBookData(id);
        if(isExist){
            return false;
        }
        db.isSuccessRemove(id);
        return true;
    }

    @Override
    public List<GenreModel> getGenres() {
        return new ArrayList<>(db.getGenres());
    }
}
