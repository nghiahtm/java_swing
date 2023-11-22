package org.example.presentations.GenreScreen;

import org.example.db.GenreDB;
import org.example.models.GenreModel;
import org.example.usecase.GenreUseCase;

import java.util.ArrayList;
import java.util.List;

public class GenreController {
    final GenreUseCase genreUseCase;

    GenreController(){
        genreUseCase = new GenreUseCase();
    }

    List<GenreModel> getGenres (){
        List<GenreModel> genres = new ArrayList<>();
        for(GenreModel genre: genreUseCase.getGenres()){
            genres.add(genre);
            if(genre.id == 0){
                genres.remove(0);
            }
        }
        return genres;
    }

    public boolean isSuccessRemove(int id){
        return genreUseCase.isSuccessRemoveGenre(id);
    }
}
