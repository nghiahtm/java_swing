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
        List<AuthorModel> authorsShow = useCase.getAuthors();
        authorsShow.remove(0);
            return authorsShow;
    }

    boolean isSuccessAdd(AuthorModel authorModel) {

        return useCase.isSuccessAddAuthor(authorModel);
    }

    boolean isRemoveAuthor(int id) {
        return useCase.isSuccessRemoveAuthor(id);
    }

    boolean isSuccessEdit(AuthorModel authorModel){
        return useCase.isSuccessEditAuthor(authorModel);
    }
}
