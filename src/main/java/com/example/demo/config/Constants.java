package com.example.demo.config;

public final class Constants {
    //select all query
    public static final String SELECT_ALL_USER = "SELECT * FROM user";
    public static final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE iduser = ?";
    public static final String ADD_USER = "INSERT into user(firstName,lastName) VALUES (?,?);";

    public static final String UPDATE_USER_BY_ID = "UPDATE user SET firstName = ? , lastName = ? WHERE iduser = ?";
    public static final String DELETE_USER_BY_ID = "DELETE FROM user WHERE iduser = ?";
}
