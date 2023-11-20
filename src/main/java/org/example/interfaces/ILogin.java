package org.example.interfaces;
import org.example.models.Authorization;
import org.example.models.UserModel;

public interface ILogin {
    UserModel getUser (Authorization userModel);
}
