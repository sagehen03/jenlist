package org.drewandjen.model;

import java.util.Date;

/**
 * Created by dhite on 8/24/15.
 */
public class ShoppingListItem {

    private String name;

    private String comment;

    private Date createdAt;

    private boolean completed;

    private int shoppingListId;

    private int id;

    public ShoppingListItem(String name, String comment, Date createdAt, boolean completed, int shoppingListId, int id) {
        this.name = name;
        this.comment = comment;
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

    public void setComment(String comment) {
        this.comment = comment;
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

    public String getComment() {
        return comment;
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
                ", comment='" + comment + '\'' +
                ", createdAt=" + createdAt +
                ", completed=" + completed +
                ", id=" + id +
                '}';
    }
}
