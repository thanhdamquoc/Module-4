package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String date;
    int starLevel;

    public Vote() {
    }

    public Vote(String date, int starLevel) {
        this.date = date;
        this.starLevel = starLevel;
    }

    public Vote(Long id, String date, int starLevel) {
        this.id = id;
        this.date = date;
        this.starLevel = starLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(int starLevel) {
        this.starLevel = starLevel;
    }
}
