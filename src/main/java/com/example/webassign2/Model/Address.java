package com.example.webassign2.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Address {

    @Id
    private Long id;
    private int street_num;
    private String street_name;
    private String city;
    private String province;
    private String postal;
    private String building_type;

    public Address() {
    }

    public Address(Long id, int street_num, String street_name, String city, String province, String postal, String building_type) {
        this.id = id;
        this.street_num = street_num;
        this.street_name = street_name;
        this.city = city;
        this.province = province;
        this.postal = postal;
        this.building_type = building_type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getStreet_num() {
        return street_num;
    }

    public void setStreet_num(int street_num) {
        this.street_num = street_num;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getBuilding_type() {
        return building_type;
    }

    public void setBuilding_type(String building_type) {
        this.building_type = building_type;
    }
}
