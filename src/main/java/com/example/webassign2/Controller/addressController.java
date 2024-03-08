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

    }

    @Override
    public void update(Address address) throws SQLException {

    }

    @Override
    public void delete(int address_id) throws SQLException {

    }

    @Override
    public Address select(String userName, String Password) throws SQLException {
        return null;
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
                        rs.getLong(1),
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
