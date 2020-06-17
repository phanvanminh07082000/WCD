package com.example.dataaccess;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDataAccess {
    private PreparedStatement loginStatement;

    public PreparedStatement getLoginStatement() throws SQLException, ClassNotFoundException {
        if (loginStatement==null){
            Connection connection = new DBConnection().getConnection();

            loginStatement = connection.prepareStatement("select * from user where username = ? and password = ?");
        }
        return loginStatement;
    }

    public boolean login(String username, String password) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = getLoginStatement();
        statement.setString(1, username);
        statement.setString(2, password);

        Result resultSet = statement.executeQuery();
        if (resultSet.next()){
            return true;
        }
        return false;
    }
}
