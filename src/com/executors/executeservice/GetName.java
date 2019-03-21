package com.executors.executeservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.Callable;

public class GetName implements Callable<String> {
    private static final String LOGIN_DB = "login";
    private static final String PASSWORD_DB = "password";
    private static final String NAME_DB = "nameBD";
    private Connection connect;
    private int id;

    public GetName(int id) throws Exception {
        connect = DriverManager.getConnection("jdbc:mysql://localhost/" + NAME_DB + "?characterEncoding=utf8", LOGIN_DB, PASSWORD_DB);
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        PreparedStatement preparedStatement = connect.prepareStatement("SELECT `name` FROM `users` WHERE `id` = ?");
        preparedStatement.setInt(1, id);
        ResultSet result = preparedStatement.executeQuery();
        return (result.next()) ? result.getString(1) : null;
    }
}
