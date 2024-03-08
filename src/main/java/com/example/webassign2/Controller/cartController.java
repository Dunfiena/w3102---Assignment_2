package com.example.webassign2.Controller;

import com.example.webassign2.Dao.cartDao;
import com.example.webassign2.Model.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.example.webassign2.Controller.database_connection.getConnection;

public class cartController implements cartDao {
    @Override
    public void insert(Cart cart) throws SQLException {

    }

    @Override
    public void update(Cart cart) throws SQLException {

    }

    @Override
    public void delete(int cartId) throws SQLException {

    }

    @Override
    public Cart select(String userName, String Password) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Cart> select(int userID) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Cart> carts = new ArrayList<>();
        Cart cart;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("Select * from cart where user_id=?");
            stmt.setInt(1, userID);
            rs = stmt.executeQuery();

            while (rs.next()) {
                cart = (new Cart(
                        rs.getLong(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7))
                );
            }
            return carts;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
