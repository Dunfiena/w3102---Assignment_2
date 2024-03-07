package com.example.webassign2.Controller;

import com.example.webassign2.Dao.productDao;
import com.example.webassign2.Model.Cart;
import com.example.webassign2.Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.example.webassign2.Controller.database_connection.getConnection;

public class productController implements productDao {
    @Override
    public void insert(Product product) throws SQLException {

    }

    @Override
    public void update(Product product) throws SQLException {

    }

    @Override
    public void delete(int product_Id) throws SQLException {

    }

    @Override
    public Product select(String userName, String Password) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Product> select(int productId) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Product> products = new ArrayList<>();
        Product product;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("Select * from product where product_id=?");
            stmt.setInt(1, productId);
            stmt.execute();

            while (rs.next()) {
                product = (new Product(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getDouble(6),
                        rs.getInt(7),
                        rs.getInt(8))
                );
            }
            return products;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
