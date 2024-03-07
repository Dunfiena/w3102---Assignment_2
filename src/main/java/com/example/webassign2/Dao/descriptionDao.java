package com.example.webassign2.Dao;


import com.example.webassign2.Model.Descriptor;

import java.sql.SQLException;

public interface descriptionDao {
    public void insert (Descriptor descriptor) throws SQLException;
    public void update (Descriptor descriptor) throws SQLException;
    public void delete (int descriptor_id) throws SQLException;
    public Descriptor select (String userName, String Password) throws SQLException;
}
