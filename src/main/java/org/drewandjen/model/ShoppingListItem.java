package org.drewandjen.model;

import java.util.Date;

/**
 * Created by dhite on 8/24/15.
 */
public class ShoppingListItem {

    private String name;

    private String comments;

    private Date createdAt;

    private boolean completed;

    private int shoppingListId;

    private int id;

    public ShoppingListItem(String name, String comment, Date createdAt, boolean completed, int shoppingListId, int id) {
        this.name = name;
        this.comments = comment;
        this.createdAt = createdAt;
        this.completed = completed;
        this.shoppingListId = shoppingListId;
        this.id = id;
    }

    public ShoppingListItem() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setShoppingListId(int shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getComments() {
        return comments;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public boolean isCompleted() {
        return completed;
    }

    public int getId() {
        return id;
    }

    public int getShoppingListId() {
        return shoppingListId;
    }

    @Override
    public String toString() {
        return "ShoppingListItem{" +
                "name='" + name + '\'' +
                ", comment='" + comments + '\'' +
                ", createdAt=" + createdAt +
                ", completed=" + completed +
                ", id=" + id +
                '}';
    }
}
