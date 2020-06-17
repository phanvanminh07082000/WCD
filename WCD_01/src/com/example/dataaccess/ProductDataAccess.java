package com.example.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductDataAccess {
    private PreparedStatement insertStatement;

    public PreparedStatement getInsertStatement() throws SQLException, ClassNotFoundException {
        if (insertStatement==null){
            Connection connection = new DBConnection().getConnection();
            insertStatement = connection.prepareStatement("insert into product(name , description) values (?,?)");
        }
        return insertStatement;
    }

    public boolean getInsertProduct(String name, String description) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = getInsertStatement();
        statement.setString(1, name);
        statement.setString(2, description);
        int resultSet = statement.executeUpdate();

        if (resultSet == 1){
            System.out.println("Create Success");
            return true;
        }
        else {
            System.out.println("Failed");
            return false;
        }
    }
}
