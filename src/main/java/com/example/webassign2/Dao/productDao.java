package com.example.webassign2.Dao;


import com.example.webassign2.Model.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface productDao {
    ArrayList<Product> select() throws SQLException;

    ArrayList<Product> select(int productId) throws SQLException;
}
