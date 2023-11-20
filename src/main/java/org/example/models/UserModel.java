package org.example.models;
public class UserModel {
    public final String userName;

    @Override
    public String toString() {
        return "UserModel{" +
                "userName='" + userName + '\'' +
                '}';
    }

    public UserModel(String userName) {
        this.userName = userName;
    }
}
