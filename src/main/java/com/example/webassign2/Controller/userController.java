package com.example.webassign2.Controller;

import com.example.webassign2.Dao.userDao;
import com.example.webassign2.Model.User;

import java.sql.SQLException;

public class userController implements userDao {
    @Override
    public void insert(User user) throws SQLException {

    }

    @Override
    public void update(User user) throws SQLException {

    }

    @Override
    public void delete(User userId) throws SQLException {

    }

    @Override
    public User select(String userName, String Password) throws SQLException {
        return null;
    }
}
