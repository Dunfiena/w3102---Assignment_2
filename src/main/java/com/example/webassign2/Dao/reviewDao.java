package com.example.webassign2.Dao;


import com.example.webassign2.Model.Review;

import java.sql.SQLException;
import java.util.ArrayList;

public interface reviewDao {
    public void insert (Review review) throws SQLException;
    public void update (Review review) throws SQLException;
    public void delete (int reviewId) throws SQLException;
    public Review select (String userName, String Password) throws SQLException;

    ArrayList<Review> select(int prodId) throws SQLException;
}
