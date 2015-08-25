package org.drewandjen.model;

import java.util.Date;

/**
 * Created by dhite on 8/24/15.
 */
public class ListItem {

    private String title;

    private String comments;

    private Date dateAdded;

    public ListItem(String title, String comments, Date dateAdded) {
        this.title = title;
        this.comments = comments;
        this.dateAdded = dateAdded;
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
}
