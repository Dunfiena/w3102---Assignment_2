package com.example.webassign2.Dao;

import com.example.webassign2.Model.User;

import java.sql.SQLException;

public interface userDao {
    public void insert (User user) throws SQLException;
    public void update (User user) throws SQLException;
    public void delete (User userId) throws SQLException;
    public User select (String userName, String Password) throws SQLException;
}
