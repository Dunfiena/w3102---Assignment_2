package com.example.webassign2.Controller;

import com.example.webassign2.Dao.reviewDao;
import com.example.webassign2.Model.Product;
import com.example.webassign2.Model.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.example.webassign2.Controller.database_connection.getConnection;

public class reviewController implements reviewDao {
    @Override
    public void insert(Review review) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("INSERT INTO `review`(`user_id`, `item_id`, `rating`, `review_text`) VALUES (?,?,?,?);");
            stmt.setInt(1, review.getUser_id());
            stmt.setInt(2, review.getItem_id());
            stmt.setInt(3, review.getRating());
            stmt.setString(4, review.getReview_text());

            stmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Review> select(int prodId) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Review review = null;
        ArrayList<Review> reviews = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("Select * from review where item_id=?");
            stmt.setInt(1, prodId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                review = (new Review(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5))

                );
                reviews.add(review);
            }
            return reviews;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
