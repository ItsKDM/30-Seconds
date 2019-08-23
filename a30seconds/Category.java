package com.example.kdm.a30seconds;

public class Category {
    public static final int SPORTS = 1;
    public static final int SCIENCE = 2;
    public static final int BOLLYWOOD = 3;
    public static final int HARRYPOTTER = 4;
    public static final int FOOD = 5;

    private int id;
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return getName();
    }
}
