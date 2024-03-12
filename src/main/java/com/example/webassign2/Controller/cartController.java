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
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("INSERT INTO `cart`(`user_id`, `item_id`, `item_quantity`, `submitted`, `shipped`, `received`) VALUES (?,?,?,?,?,?)");
            stmt.setInt(1, cart.getUser_id());
            stmt.setInt(2, cart.getItem_id());
            stmt.setInt(3, cart.getItem_quantity());
            stmt.setInt(4, cart.getSubmitted());
            stmt.setInt(5, cart.getShipped());
            stmt.setInt(6, cart.getRecieved());


            stmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Cart cart) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("UPDATE `cart` SET `item_quantity`=?,`submitted`=?,`shipped`=?,`received`=? WHERE cart_id=?");
            stmt.setInt(1, cart.getItem_quantity());
            stmt.setInt(2, cart.getSubmitted());
            stmt.setInt(3, cart.getShipped());
            stmt.setInt(4, cart.getRecieved());
            stmt.setInt(5, cart.getId());


            stmt.executeUpdate();
        }catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

    @Override
    public void delete(int cartId) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM cart WHERE cart_id=?;");
            stmt.setInt(1, cartId);
            stmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
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
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7))
                );
                carts.add(cart);
            }
            return carts;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
