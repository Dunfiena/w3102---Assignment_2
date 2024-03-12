package com.example.webassign2.Dao;

import com.example.webassign2.Model.Address;

import java.sql.SQLException;

public interface addressDao {
    public Address insert (Address address) throws SQLException;

    Address select(int streetNum, String streetName, String postal) throws SQLException;

    Address select(int addressid) throws SQLException;
}
