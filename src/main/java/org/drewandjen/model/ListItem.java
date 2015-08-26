package org.drewandjen.model;

import java.util.Date;

/**
 * Created by dhite on 8/24/15.
 */
public class ListItem {

    private String title;

    private String comments;

    private Date dateAdded;

    private boolean completed;

    private int id;

    public ListItem(int id, String title, String comments, Date dateAdded, boolean completed) {
        this.id = id;
        this.title = title;
        this.comments = comments;
        this.dateAdded = dateAdded;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public String getComments() {
        return comments;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public boolean isCompleted() {
        return completed;
    }

    public int getId() {
        return id;
    }
}
