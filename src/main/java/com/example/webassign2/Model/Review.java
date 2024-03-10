package com.example.webassign2.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Review {
    @Id
    private int id;
    private int user_id;
    private int item_id;
    private int rating;
    private String review_text;

    public Review() {
    }

    public Review(int id, int user_id, int item_id, int rating, String review_text) {
        this.id = id;
        this.user_id = user_id;
        this.item_id = item_id;
        this.rating = rating;
        this.review_text = review_text;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview_text() {
        return review_text;
    }

    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }
}
