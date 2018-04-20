package com.example.blog.models;


import javax.persistence.*;

@Entity
@Table(name="post_details")
public class PostDetails {

    @Id @GeneratedValue
    @Column(columnDefinition = "INT(11) UNSIGNED")
    private long id;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String location;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public PostDetails(double price, String location) {
        this.price = price;
        this.location = location;
    }

    public PostDetails() {
    }
}
