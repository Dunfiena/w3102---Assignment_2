package com.example.webassign2.Dao;


import com.example.webassign2.Model.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface productDao {
    public void insert (Product product) throws SQLException;
    public void update (Product product) throws SQLException;
    public void delete (int product_Id) throws SQLException;
    public Product select (String userName, String Password) throws SQLException;
    ArrayList<Product> select(int productId) throws SQLException;
}
