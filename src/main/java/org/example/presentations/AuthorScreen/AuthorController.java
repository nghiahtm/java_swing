package org.example.presentations.AuthorScreen;

import org.example.models.AuthorModel;
import org.example.models.AuthorModel;
import org.example.usecase.AuthorUseCase;

import java.util.List;

public class AuthorController {
    private final AuthorUseCase useCase;

    public AuthorController() {
        useCase = new AuthorUseCase();
    }

    List<AuthorModel> getAuthors () {
            return useCase.getAuthors();
    }

    boolean isSuccessAdd(AuthorModel authorModel) {
       return useCase.isSuccessAddAuthor(authorModel);
    }

}
