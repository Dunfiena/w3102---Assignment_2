package com.example.webassign2.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Descriptor {
    @Id
    private Long id;
    private String color;
    private String type;
    private String materials;
    private int pattern;
    private int print;

    public Descriptor() {
    }

    public Descriptor(Long id, String color, String type, String materials, int pattern, int print) {
        this.id = id;
        this.color = color;
        this.type = type;
        this.materials = materials;
        this.pattern = pattern;
        this.print = print;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public int getPattern() {
        return pattern;
    }

    public void setPattern(int pattern) {
        this.pattern = pattern;
    }

    public int getPrint() {
        return print;
    }

    public void setPrint(int print) {
        this.print = print;
    }
}
