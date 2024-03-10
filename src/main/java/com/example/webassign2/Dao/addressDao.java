package com.example.webassign2.Dao;

import com.example.webassign2.Model.Address;

import java.sql.SQLException;

public interface addressDao {
    public void insert (Address address) throws SQLException;
    Address select(int addressid) throws SQLException;
}
