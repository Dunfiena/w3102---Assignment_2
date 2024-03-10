package com.example.webassign2.Dao;


import com.example.webassign2.Model.Cart;

import java.sql.SQLException;
import java.util.ArrayList;

public interface cartDao {
    public void insert (Cart cart) throws SQLException;
    public void update (Cart cart) throws SQLException;
    public void delete (int cartId) throws SQLException;
    ArrayList<Cart> select(int userID) throws SQLException;
}
