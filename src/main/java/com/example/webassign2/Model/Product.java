package com.example.webassign2.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    private Long id;
    private String product_name;
    private String description;
    private int review_id;
    private int rating_total;
    private double price;
    private int quantity;
    private int descriptor_id;

    public Product() {
    }

    public Product(Long id, String product_name, String description, int review_id, int rating_total, double price, int quantity, int descriptor_id) {
        this.id = id;
        this.product_name = product_name;
        this.description = description;
        this.review_id = review_id;
        this.rating_total = rating_total;
        this.price = price;
        this.quantity = quantity;
        this.descriptor_id = descriptor_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public int getRating_total() {
        return rating_total;
    }

    public void setRating_total(int rating_total) {
        this.rating_total = rating_total;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDescriptor_id() {
        return descriptor_id;
    }

    public void setDescriptor_id(int descriptor_id) {
        this.descriptor_id = descriptor_id;
    }
}
