package com.example.movie_description.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Movie title is required")
    private String title;

    @DecimalMin(value = "0.0", message = "Rating cannot be below 0")
    @DecimalMax(value = "10.0", message = "Rating cannot exceed 10")
    private double rating;

    @Column(length = 2000)
    private String description;

    public Movie() {
    }

    public Movie(String title, double rating, String description) {
        this.title = title;
        this.rating = rating;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}