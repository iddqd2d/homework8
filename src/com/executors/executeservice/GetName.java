package com.executors.executeservice;

import java.sql.*;
import java.util.concurrent.Callable;

public class GetName implements Callable<String> {
    private Connection connect;
    private PreparedStatement preparedStatement;
    private int id;

    GetName(int id) throws Exception{
        connect = DriverManager.getConnection("jdbc:mysql://localhost/nameBD?characterEncoding=utf8", "login", "password");
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        preparedStatement = connect.prepareStatement("SELECT `name` FROM `users` WHERE `id` = ?");
        preparedStatement.setInt(1, id);
        ResultSet result = preparedStatement.executeQuery();
        return (result.next())? result.getString(1): null;
    }
}
