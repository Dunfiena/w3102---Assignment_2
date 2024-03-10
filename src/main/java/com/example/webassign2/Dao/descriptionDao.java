package com.example.webassign2.Dao;


import com.example.webassign2.Model.Descriptor;

import java.sql.SQLException;
import java.util.ArrayList;

public interface descriptionDao {
    ArrayList<Descriptor> select (String color, String type,String material, int pattern, int print) throws SQLException;
}
