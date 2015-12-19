package org.drewandjen.model;

/**
 * Created by dhite on 11/12/15.
 */
public class Category {

    private int id;

    private String name;

    public Category() {

    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
