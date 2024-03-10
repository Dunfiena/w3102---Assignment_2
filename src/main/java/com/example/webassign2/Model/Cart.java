package com.example.webassign2.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cart {
    @Id
    private int id;
    private int user_id;
    private int item_id;
    private int item_quantity;
    private int submitted;
    private int shipped;
    private int recieved;

    public Cart() {
    }

    public Cart(int id, int user_id, int item_id, int item_quantity, int submitted, int shipped, int recieved) {
        this.id = id;
        this.user_id = user_id;
        this.item_id = item_id;
        this.item_quantity = item_quantity;
        this.submitted = submitted;
        this.shipped = shipped;
        this.recieved = recieved;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getItem_quantity() {
        return item_quantity;
    }

    public void setItem_quantity(int item_quantity) {
        this.item_quantity = item_quantity;
    }

    public int getSubmitted() {
        return submitted;
    }

    public void setSubmitted(int submitted) {
        this.submitted = submitted;
    }

    public int getShipped() {
        return shipped;
    }

    public void setShipped(int shipped) {
        this.shipped = shipped;
    }

    public int getRecieved() {
        return recieved;
    }

    public void setRecieved(int recieved) {
        this.recieved = recieved;
    }
}
