package com.example.webassign2.Controller;

import com.example.webassign2.Dao.productDao;
import com.example.webassign2.Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.example.webassign2.Controller.database_connection.getConnection;

public class productController implements productDao {
    @Override
    public ArrayList<Product> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Product> products = new ArrayList<>();
        Product product;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("Select * from product");
            rs = stmt.executeQuery();

            while (rs.next()) {
                product = (new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getDouble(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9))
                );
                products.add(product);
            }
            return products;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }    }

    @Override
    public Product select(int productId) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Product product = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("Select * from product where product_id=?");
            stmt.setInt(1, productId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                product = (new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getDouble(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9))

                );
                return product;
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return product;
    }
}
