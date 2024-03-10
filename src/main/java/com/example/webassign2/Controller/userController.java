package com.example.webassign2.Controller;

import com.example.webassign2.Dao.userDao;
import com.example.webassign2.Model.Address;
import com.example.webassign2.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.webassign2.Controller.database_connection.getConnection;

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
    public User select(String email, String password) throws SQLException {
        User user = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            conn = getConnection();
            stmt = conn.prepareStatement("select * from user where email=? and password=?");
            stmt.setString(1, email);
            stmt.setString(2, password);

            rs = stmt.executeQuery();

            while (rs.next()){
                user = (new User(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)
                ));
                return user;

            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
