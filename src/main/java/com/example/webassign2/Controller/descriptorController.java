package com.example.webassign2.Controller;

import com.example.webassign2.Dao.descriptionDao;
import com.example.webassign2.Model.Cart;
import com.example.webassign2.Model.Descriptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import static com.example.webassign2.Controller.database_connection.getConnection;

public class descriptorController implements descriptionDao {

    @Override
    public ArrayList<Descriptor> select(String color, String type,String material, int pattern, int print) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Descriptor> descriptors = new ArrayList<>();
        Descriptor descriptor1;
        try {
            conn = getConnection();

            stmt = conn.prepareStatement("SELECT * from descriptor where color=? or type=? or materials=? or pattern=? or print=?");
            stmt.setString(1, color);
            stmt.setString(2, type);
            stmt.setString(3, material);
            stmt.setInt(4, pattern);
            stmt.setInt(5, print);

            rs = stmt.executeQuery();

            while (rs.next()) {
                descriptor1 = (new Descriptor(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6))
                );
                descriptors.add(descriptor1);
            }
            return descriptors;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }    }
}
