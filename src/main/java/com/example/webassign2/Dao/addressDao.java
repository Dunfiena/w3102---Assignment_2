package com.example.webassign2.Dao;

import com.example.webassign2.Model.Address;

import java.sql.SQLException;

public interface addressDao {
    public void insert (Address address) throws SQLException;
    public void update (Address address) throws SQLException;
    public void delete (int address_id) throws SQLException;
    public Address select (String userName, String Password) throws SQLException;
}
