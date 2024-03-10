package com.example.webassign2.Dao;


import com.example.webassign2.Model.Descriptor;

import java.sql.SQLException;
import java.util.ArrayList;

public interface descriptionDao {
    public void insert (Descriptor descriptor) throws SQLException;
    public void update (Descriptor descriptor) throws SQLException;
    public void delete (int descriptor_id) throws SQLException;
    public ArrayList<Descriptor> select (String color, String type,String material, int pattern, int print) throws SQLException;
}
