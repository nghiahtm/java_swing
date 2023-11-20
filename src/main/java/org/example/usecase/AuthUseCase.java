package org.example.usecase;
import org.example.db.LoginDB;
import org.example.interfaces.ILogin;
import org.example.models.Authorization;
import org.example.models.UserModel;

public class AuthUseCase implements ILogin
{
    @Override
    public UserModel getUser(Authorization authorization) {
        return new LoginDB().getUser(authorization);
    }
}
