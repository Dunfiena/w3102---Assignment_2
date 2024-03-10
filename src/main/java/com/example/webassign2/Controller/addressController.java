package com.example.webassign2.Controller;

import com.example.webassign2.Dao.addressDao;
import com.example.webassign2.Model.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.webassign2.Controller.database_connection.getConnection;

public class addressController implements addressDao {
    @Override
    public void insert(Address address) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("INSERT INTO `address`(`street_num`, `street_name`, `city`, `province`, `postal`, `building_type`) VALUES (?,?,?,?,?,?,)");
            stmt.setInt(1, address.getStreet_num());
            stmt.setString(2, address.getStreet_name());
            stmt.setString(3, address.getCity());
            stmt.setString(4, address.getProvince());
            stmt.setString(5, address.getPostal());
            stmt.setString(6, address.getBuilding_type());


            stmt.executeQuery();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

        @Override
    public Address select(int addressid) throws SQLException {
        Address address = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            conn = getConnection();
            stmt = conn.prepareStatement("select * from address where address_id=?");
            stmt.setInt(1, addressid);

            rs = stmt.executeQuery();

            while (rs.next()){
                address = (new Address(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                        ));
                return address;

            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return address;
    }
}
